package com.example.petverse.ui

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create a simple layout programmatically
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 32, 32, 32)
        }

        val textView = TextView(this).apply {
            text = "🐾 PETVERSE IS WORKING! 🐾\n\nThis proves our MainActivity is running!\n\nIf you can see this, the cache issue is fixed!"
            textSize = 18f
            setPadding(0, 0, 0, 16)
        }

        layout.addView(textView)
        setContentView(layout)
    }
}