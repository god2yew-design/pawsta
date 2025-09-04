package com.example.petverse.ui

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // First try with traditional Android View to ensure it works
        val textView = TextView(this).apply {
            text = "🐾 PETVERSE IS WORKING! 🐾\n\nThis proves our MainActivity is running!"
            textSize = 24f
            setPadding(50, 50, 50, 50)
        }
        setContentView(textView)

        // Alternative: Uncomment this to test Compose
        /*
        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "🐾 PETVERSE 🐾",
                        style = MaterialTheme.typography.displayLarge
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "WORKING!",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }
        }
        */
    }
}