package com.example.basicapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.basicapp.ui.theme.BasicAppTheme

class InfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicAppTheme {
                InfoScreen(
                    onGoToContact = {
                        startActivity(Intent(this, ContactActivity::class.java))
                    }
                )
            }
        }
    }
}

@Composable
fun InfoScreen(onGoToContact: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Info", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text("This is a screen showing some info about the app.")

            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = onGoToContact) {
                Text("GO TO CONTACT")
            }
        }
    }
}
