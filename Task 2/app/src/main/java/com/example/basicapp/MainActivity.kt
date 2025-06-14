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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicAppTheme {
                HomeScreen(
                    onGoToInfo = {
                        startActivity(Intent(this, InfoActivity::class.java))
                    },
                    onGoToContact = {
                        startActivity(Intent(this, ContactActivity::class.java))
                    }
                )
            }
        }
    }
}

@Composable
fun HomeScreen(onGoToInfo: () -> Unit, onGoToContact: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Info App!", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = onGoToInfo) {
                Text("GO TO INFO")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = onGoToContact) {
                Text("GO TO CONTACT")
            }
        }
    }
}
