package com.petverse.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a simple layout programmatically
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(32, 32, 32, 32);

        TextView textView = new TextView(this);
        textView.setText("🐾 PETVERSE TEST SUCCESS! 🐾\n\nThis is a completely new activity!\n\nIf you see this, the cache issue is bypassed!");
        textView.setTextSize(18);
        textView.setPadding(0, 0, 0, 16);

        layout.addView(textView);
        setContentView(layout);
    }
}