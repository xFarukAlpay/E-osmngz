package com.example.e_osmangazi

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ChatActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var messageInput: EditText
    private lateinit var sendButton: Button
    private lateinit var chatAdapter: ChatAdapter
    private val messages = mutableListOf<ChatMessage>()
    private lateinit var database: DatabaseReference
    private val responseMap = mutableMapOf<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat)

        recyclerView = findViewById(R.id.recyclerViewMessages)
        messageInput = findViewById(R.id.editTextMessage)
        sendButton = findViewById(R.id.buttonSend)

        chatAdapter = ChatAdapter(messages)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = chatAdapter

        database = FirebaseDatabase.getInstance().getReference("responses")

        // Veritabanından yanıtları çek
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                responseMap.clear()
                for (childSnapshot in snapshot.children) {
                    val key = childSnapshot.key ?: continue
                    val value = childSnapshot.getValue(String::class.java) ?: continue
                    responseMap[key] = value
                    Log.d("FirebaseData", "Loaded response for key: $key")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Hata yönetimi
                Log.e("FirebaseError", "Database error: ${error.toException()}")
            }
        })

        sendButton.setOnClickListener {
            val messageText = messageInput.text.toString()
            if (messageText.isNotBlank()) {
                val userMessage = ChatMessage("User", messageText)
                addMessageToChat(userMessage)

                Log.d("ChatActivity", "User message: $messageText")

                val responseMessage = getResponseForMessage(userMessage.message)
                if (responseMessage != null) {
                    Log.d("ChatActivity", "Bot response: $responseMessage")
                    val botMessage = ChatMessage("Bot", responseMessage)
                    addMessageToChat(botMessage)
                } else {
                    Log.d("ChatActivity", "No response found for: $messageText")
                }
            }
        }
    }

    private fun addMessageToChat(chatMessage: ChatMessage) {
        messages.add(chatMessage)
        chatAdapter.notifyItemInserted(messages.size - 1)
        recyclerView.scrollToPosition(messages.size - 1)
        messageInput.text.clear()
    }

    private fun getResponseForMessage(message: String): String? {
        // En iyi eşleşmeyi bul
        return findBestMatch(message, responseMap)
    }
}
