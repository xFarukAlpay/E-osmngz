package com.example.e_osmangazi

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherFetcher {
    suspend fun fetchWeather(): String {
        val url = "https://www.google.com.tr/search?q=osmangazi+anl%C4%B1k+hava+durumu&sca_esv=e4dd71f640266e19&sca_upv=1&sxsrf=ADLYWIKM71LOhdLxJCrznLk6iyJRnRzxfA%3A1722541619896&ei=M-arZq79MsCrxc8P3Nb6sAI&ved=0ahUKEwju4vHKx9SHAxXAVfEDHVyrHiYQ4dUDCBA&uact=5&oq=osmangazi+anl%C4%B1k+hava+durumu&gs_lp=Egxnd3Mtd2l6LXNlcnAiHG9zbWFuZ2F6aSBhbmzEsWsgaGF2YSBkdXJ1bXUyBBAAGEcyBBAAGEcyBBAAGEcyBBAAGEcyBBAAGEcyBBAAGEcyBBAAGEcyBBAAGEdItgZQAFgAcAB4ApABAJgBAKABAKoBALgBA8gBAJgCAaACA5gDAIgGAZAGCJIHATGgBwA&sclient=gws-wiz-serp"
        return withContext(Dispatchers.IO) {
            try {
                // HTML sayfasını al
                val document: Document = Jsoup.connect(url).get()

                // Sayfanın HTML içeriğini yazdır (Debugging amacıyla)
                println("HTML içeriği:")
                println(document.html())

                // HTML içeriğinden sıcaklık bilgisini seç
                val temperatureElement: Element? = document.selectFirst("span#wob_tm")
                val temperature: String? = temperatureElement?.text()

                // HTML içeriğinden hava durumu bilgisini seç
                val conditionElement: Element? = document.selectFirst("span#wob_dc")
                val condition: String? = conditionElement?.text()

                // Bilgiyi oluştur
                val weatherInfo = buildString {
                    appendLine("$temperature °C")
                    appendLine("$condition")
                }

                // Bilgileri terminale yazdır
                println("Hava Durumu Bilgisi:")
                println(weatherInfo)

                weatherInfo ?: "Hava durumu bilgisi bulunamadı."
            } catch (e: Exception) {
                "Hata: ${e.message}"
            }
        }
    }
}
