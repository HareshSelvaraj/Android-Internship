package com.example.basicapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.basicapp.ui.theme.BasicAppTheme
import com.google.firebase.firestore.FirebaseFirestore

class ContactActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicAppTheme {
                ContactScreen(onSend = { message ->

                    val db = FirebaseFirestore.getInstance()
                    val data = hashMapOf(
                        "message" to message,
                        "timestamp" to System.currentTimeMillis()
                    )

                    db.collection("messages")
                        .add(data)
                        .addOnSuccessListener {
                            Toast.makeText(
                                this,
                                "Message saved to Firebase!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        .addOnFailureListener {
                            Toast.makeText(
                                this,
                                "Error saving message",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                })
            }
        }
    }
}

@Composable
fun ContactScreen(onSend: (String) -> Unit) {
    var message by remember { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Contact", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                label = { Text("Enter your message") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = {
                if (message.isNotBlank()) {
                    onSend(message)
                }
            }) {
                Text("SEND")
            }
        }
    }
}
