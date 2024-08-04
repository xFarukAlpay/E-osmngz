package com.example.e_osmangazi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var messageInput: EditText
    private lateinit var sendButton: Button
    private lateinit var chatAdapter: ChatAdapter
    private val messages = mutableListOf<ChatMessage>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat)

        recyclerView = findViewById(R.id.recyclerViewMessages)
        messageInput = findViewById(R.id.editTextMessage)
        sendButton = findViewById(R.id.buttonSend)

        chatAdapter = ChatAdapter(messages)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = chatAdapter

        sendButton.setOnClickListener {
            val messageText = messageInput.text.toString()
            if (messageText.isNotBlank()) {
                val userMessage = ChatMessage("User", messageText)
                messages.add(userMessage)
                chatAdapter.notifyItemInserted(messages.size - 1)
                recyclerView.scrollToPosition(messages.size - 1)
                messageInput.text.clear()

                // Kullanıcıdan gelen mesajı kontrol et ve uygun yanıtı gönder
                val responseMessage = getResponseForMessage(userMessage.message)
                if (responseMessage != null) {
                    val botMessage = ChatMessage("Bot", responseMessage)
                    messages.add(botMessage)
                    chatAdapter.notifyItemInserted(messages.size - 1)
                    recyclerView.scrollToPosition(messages.size - 1)
                }
            }
        }
    }


    private fun getResponseForMessage(message: String): String? {
        val normalizedMessage = message.lowercase().trim()
        return when {


            normalizedMessage.contains("su kesinti") || normalizedMessage.contains("su kesintisi") ->
                    "Su kesintileri hakkında bilgi almak için Osmangazi Belediyesi Su ve Kanalizasyon Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 78."
            normalizedMessage.contains("osmangazi") && normalizedMessage.contains("su kesintisi") ->
                    "Osmangazi ilçesindeki su kesintileri hakkında bilgi almak için Osmangazi Belediyesi Su ve Kanalizasyon Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 78."
            normalizedMessage.contains("elektrik kesinti") || normalizedMessage.contains("elektrik kesintisi") ->
                    "Elektrik kesintileri hakkında bilgi almak için Osmangazi Belediyesi Elektrik Dağıtım Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 79."
            normalizedMessage.contains("osmangazi") && normalizedMessage.contains("elektrik kesintisi") ->
                    "Osmangazi ilçesindeki elektrik kesintileri hakkında bilgi almak için Osmangazi Belediyesi Elektrik Dağıtım Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 79."
            normalizedMessage.contains("doğalgaz kesinti") || normalizedMessage.contains("doğalgaz kesintisi") ->
                    "Doğalgaz kesintileri hakkında bilgi almak için Osmangazi Belediyesi Doğalgaz Dağıtım Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 80."
            normalizedMessage.contains("osmangazi") && normalizedMessage.contains("doğalgaz kesintisi") ->
                    "Osmangazi ilçesindeki doğalgaz kesintileri hakkında bilgi almak için Osmangazi Belediyesi Doğalgaz Dağıtım Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 80."
            normalizedMessage.contains("bozuk yol") || normalizedMessage.contains("bozuk yollar") ->
                    "Bozuk yollar hakkında bilgi vermek veya şikayette bulunmak için Osmangazi Belediyesi Yol Bakım ve Onarım Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 81."
            normalizedMessage.contains("osmangazi") && normalizedMessage.contains("bozuk yol") ->
                    "Osmangazi ilçesindeki bozuk yollar hakkında bilgi vermek veya şikayette bulunmak için Osmangazi Belediyesi Yol Bakım ve Onarım Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 81."
            normalizedMessage.contains("temizlik") || normalizedMessage.contains("temizlik sorunları") ->
                    "Temizlik sorunları hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Temizlik İşleri Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 82."
            normalizedMessage.contains("osmangazi") && normalizedMessage.contains("temizlik sorunları") ->
                    "Osmangazi ilçesindeki temizlik sorunları hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Temizlik İşleri Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 82."
            normalizedMessage.contains("çöp") || normalizedMessage.contains("çöp toplama") ->
                    "Çöp toplama hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Çöp Toplama Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 83."
            normalizedMessage.contains("osmangazi") && normalizedMessage.contains("çöp toplama") ->
                    "Osmangazi ilçesindeki çöp toplama hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Çöp Toplama Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 83."
            normalizedMessage.contains("yol asfaltı") || normalizedMessage.contains("yol asfaltı durumu") ->
                    "Yol asfaltı durumu hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Yol Bakım ve Onarım Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 81."
            normalizedMessage.contains("park") || normalizedMessage.contains("park sorunları") ->
                    "Park sorunları hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Park ve Bahçeler Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 84."
            normalizedMessage.contains("osmangazi") && normalizedMessage.contains("park sorunları") ->
                    "Osmangazi ilçesindeki park sorunları hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Park ve Bahçeler Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 84."
            normalizedMessage.contains("trafik") || normalizedMessage.contains("trafik sorunları") ->
                    "Trafik sorunları hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Trafik Kontrol Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 85."
            normalizedMessage.contains("osmangazi") && normalizedMessage.contains("trafik sorunları") ->
                    "Osmangazi ilçesindeki trafik sorunları hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Trafik Kontrol Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 85."
            normalizedMessage.contains("hayvan") || normalizedMessage.contains("sahipsiz hayvan") ->
                    "Sahipsiz hayvanlar hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Hayvan Barınma Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 86."
            normalizedMessage.contains("osmangazi") && normalizedMessage.contains("sahipsiz hayvan") ->
                    "Osmangazi ilçesindeki sahipsiz hayvanlar hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Hayvan Barınma Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 86."
            normalizedMessage.contains("acil") || normalizedMessage.contains("acil durum") ->
                    "Acil durumlar hakkında bilgi almak veya yardım talep etmek için Osmangazi Belediyesi Acil Yardım Merkezi'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 87."
            normalizedMessage.contains("osmangazi") && normalizedMessage.contains("acil durum") ->
                    "Osmangazi ilçesinde acil durumlar hakkında bilgi almak veya yardım talep etmek için Osmangazi Belediyesi Acil Yardım Merkezi'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 87."
            normalizedMessage.contains("kaldırım") || normalizedMessage.contains("kaldırım sorunları") ->
                    "Kaldırım sorunları hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Kaldırım Bakım Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 88."
            normalizedMessage.contains("osmangazi") && normalizedMessage.contains("kaldırım sorunları") ->
                    "Osmangazi ilçesindeki kaldırım sorunları hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Kaldırım Bakım Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 88."
            normalizedMessage.contains("yağış") || normalizedMessage.contains("yağış durumu") ->
                    "Yağış durumu hakkında bilgi almak için Osmangazi Belediyesi Meteoroloji Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 89."
            normalizedMessage.contains("osmangazi") && normalizedMessage.contains("yağış durumu") ->
                    "Osmangazi ilçesindeki yağış durumu hakkında bilgi almak için Osmangazi Belediyesi Meteoroloji Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 89."
            normalizedMessage.contains("trafik ışığı") || normalizedMessage.contains("trafik ışığı arızası") ->
                    "Trafik ışığı arızaları hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Trafik Kontrol Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 85."
            normalizedMessage.contains("osmangazi") && normalizedMessage.contains("trafik ışığı arızası") ->
                    "Osmangazi ilçesindeki trafik ışığı arızaları hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Trafik Kontrol Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 85."
            normalizedMessage.contains("çocuk parkı") || normalizedMessage.contains("çocuk parkı sorunları") ->
                    "Çocuk parkları hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Park ve Bahçeler Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 84."
            normalizedMessage.contains("osmangazi") && normalizedMessage.contains("çocuk parkı sorunları") ->
                    "Osmangazi ilçesindeki çocuk parkları hakkında bilgi almak veya şikayette bulunmak için Osmangazi Belediyesi Park ve Bahçeler Müdürlüğü'ne başvurabilirsiniz. Telefon numarası: 0224 234 56 84."
            normalizedMessage.contains("osmangazi") -> "Osmangazi Belediyesi ile ilgili daha fazla bilgi almak için resmi web sitesini ziyaret edebilir veya 0224 234 56 78 numaralı telefonu arayabilirsiniz."
            normalizedMessage.contains("merhaba") -> "Merhaba, nasıl yardımcı olabilirim?"
            normalizedMessage.contains("nasılsın") || normalizedMessage.contains("nasılsınız") -> "Ben bir yapay zekayım, ama sizinle burada olmaktan mutluyum!"
            normalizedMessage.contains("günaydın") -> "Günaydın! Size nasıl yardımcı olabilirim?"
            normalizedMessage.contains("iyi akşamlar") -> "İyi akşamlar! Bugün size nasıl yardımcı olabilirim?"
            normalizedMessage.contains("teşekkür ederim") || normalizedMessage.contains("teşekkürler") -> "Rica ederim, her zaman buradayım!"
            normalizedMessage.contains("yardım") -> "Size nasıl yardımcı olabilirim? Herhangi bir konuda bilgi almak istiyorsanız sorunuzu sorabilirsiniz."
            normalizedMessage.contains("neler yapabilirsin") -> "Size bilgi verebilir, sorularınızı yanıtlayabilir ve birçok konuda yardımcı olabilirim."
            normalizedMessage.contains("hoşça kal") || normalizedMessage.contains("görüşürüz") -> "Hoşça kalın! Tekrar görüşmek üzere."
            normalizedMessage.contains("ismin ne") || normalizedMessage.contains("adın ne") -> "Ben bir yapay zeka asistanıyım, ismim yok ama size yardımcı olabilirim."
            normalizedMessage.contains("saat kaç") -> "Saat bilgisini şu an veremiyorum ama cihazınızdan kontrol edebilirsiniz."
            normalizedMessage.contains("hava nasıl") -> "Hava durumu hakkında bilgi veremem ama hava durumu uygulamalarından öğrenebilirsiniz."
            normalizedMessage.contains("nerelisin") -> "Ben dijital bir asistanım, belirli bir yerden değilim."
            normalizedMessage.contains("neden buradasın") -> "Size yardımcı olmak ve sorularınızı yanıtlamak için buradayım."
            normalizedMessage.contains("ne yapıyorsun") -> "Sizinle iletişim kurmaya çalışıyorum ve yardımcı olmaya hazırım."
            normalizedMessage.contains("osmangazi ilçesi gezilecek yerler nerelerdir?") -> "Osmangazi'de gezilecek yerler arasında Tophane, Ulu Cami, Bursa Kalesi, Koza Han ve Muradiye Külliyesi gibi tarihi mekanlar bulunmaktadır."
            else -> "Üzgünüm, bu konuda size yardımcı olamıyorum."
        }
    }
}
