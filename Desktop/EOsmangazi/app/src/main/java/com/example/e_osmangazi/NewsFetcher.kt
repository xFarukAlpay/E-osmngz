package com.example.e_osmangazi

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.IOException

class NewsFetcher {
    data class NewsItem(
        val title: String,
        val imageUrl: String
    )



    fun fetchNewsItemsFromUrl(url: String): List<NewsItem> {
        return try {
            val document: Document = Jsoup.connect(url).get()
            val newsElements = document.select("li.nws").take(5)
            val newsItems = mutableListOf<NewsItem>()
            for (element in newsElements) {
                val title = element.select("span.title").text()
                val imageUrl = element.select("img").attr("data-original")  // `data-original` yerine `src` kullanıldı
                newsItems.add(NewsItem(title, imageUrl))
            }
            newsItems
        } catch (e: IOException) {
            e.printStackTrace()
            emptyList()
        }
    }
}
