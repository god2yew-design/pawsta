package com.example.petverse.ui

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ultra simple - just a TextView
        val textView = TextView(this).apply {
            text = "PETVERSE SUCCESS!\nCache bypassed!"
            textSize = 24f
            setPadding(50, 50, 50, 50)
        }

        setContentView(textView)
    }
}