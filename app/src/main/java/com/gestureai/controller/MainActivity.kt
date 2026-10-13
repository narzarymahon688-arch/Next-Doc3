package com.gestureai.controller

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(24, 24, 24, 24)
        }

        layout.addView(TextView(this).apply {
            text = "Gesture AI Controller"
            textSize = 26f
            gravity = Gravity.CENTER
        })

        layout.addView(TextView(this).apply {
            text = "\nAndroid 14 Hand Controller\n\nNext: camera hand tracking, floating cursor, clicks, swipes and scrolling."
            textSize = 17f
            gravity = Gravity.CENTER
        })

        layout.addView(Button(this).apply {
            text = "Start Hand Tracking"
            setOnClickListener {
                android.widget.Toast.makeText(
                    this@MainActivity,
                    "Hand tracking is not implemented yet.",
                    android.widget.Toast.LENGTH_LONG
                ).show()
            }
        })

        setContentView(layout)
    }
}