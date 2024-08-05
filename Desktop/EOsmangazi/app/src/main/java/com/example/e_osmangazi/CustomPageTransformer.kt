import android.view.View
import androidx.viewpager2.widget.ViewPager2

class CustomPageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val offset = 1f// Yan sayfaların görünür kısmı
        val pageWidth = page.width
        val pageMargin = pageWidth * offset
        val scaleFactor = Math.max(0.95f, 1 - Math.abs(position))
        val offsetPixels = pageMargin * Math.abs(position)

        page.translationX = offsetPixels
        page.scaleX = scaleFactor
        page.scaleY = scaleFactor
        page.alpha = if (position <= 1.0f && position >= -1.0f) 1.0f else 0.0f
    }
}
