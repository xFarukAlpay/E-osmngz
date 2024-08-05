package com.example.e_osmangazi

import CustomPageTransformer
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var weatherTextView: TextView
    private lateinit var viewPager: ViewPager2
    private lateinit var newsTextView: TextView
    private lateinit var imageButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TextView, ViewPager2 ve ImageButton'ı bul
        weatherTextView = findViewById(R.id.weatherTextView)
        viewPager = findViewById(R.id.viewPager)
        newsTextView = findViewById(R.id.newsTextView)
        imageButton = findViewById(R.id.imageButton)
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)


        // Hava durumu bilgisini al ve göster
        lifecycleScope.launch {
            try {
                val weatherFetcher = WeatherFetcher()
                val weatherInfo = withContext(Dispatchers.IO) {
                    weatherFetcher.fetchWeather()
                }
                weatherTextView.text = weatherInfo
            } catch (e: Exception) {
                weatherTextView.text = "Hava durumu bilgisi alınamadı."
            }
        }

        // Haber başlıklarını ve resimlerini al ve göster
        lifecycleScope.launch {
            try {
                val newsFetcher = NewsFetcher()
                val newsItems = withContext(Dispatchers.IO) {
                    newsFetcher.fetchNewsItemsFromUrl("https://www.sondakika.com/osmangazi")
                }
                if (newsItems.isNotEmpty()) {
                    // ViewPager2'yi yapılandır
                    viewPager.adapter = NewsAdapter(newsItems)
                    viewPager.setPageTransformer(CustomPageTransformer())

                } else {
                    newsTextView.text = "Haber bulunamadı."
                }
            } catch (e: Exception) {
                newsTextView.text = "Haberler alınamadı."
            }
        }

        // ChatActivity'yi başlatmak için ImageButton tıklama olayı
        imageButton.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
    }
}
