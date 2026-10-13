package com.gestureai.controller

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

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
            text = "\nAndroid 14 Hand Control\n\n" +
                "Camera tracking, cursor control, clicking, " +
                "scrolling and swiping are being integrated."
            textSize = 17f
            gravity = Gravity.CENTER
        })

        layout.addView(makeButton("Allow Camera") {
            if (checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(
                    arrayOf(Manifest.permission.CAMERA), 10
                )
            } else {
                Toast.makeText(
                    this, "Camera permission already granted",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        layout.addView(makeButton("Enable Phone Controls") {
            startActivity(
                Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
            )
        })

        setContentView(layout)
    }

    private fun makeButton(
        label: String,
        action: () -> Unit
    ): Button {
        return Button(this).apply {
            text = label
            setOnClickListener { action() }
        }
    }
}