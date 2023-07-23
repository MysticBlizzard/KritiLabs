package com.example.kritilabs

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions


class LockConnectionActivity : AppCompatActivity() {
    private lateinit var lockedImageView: ImageView
    private lateinit var otpEditText: EditText
    private lateinit var submitButton2: Button
    private lateinit var loaderImageView: ImageView
    private lateinit var unlockedImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lockconnection)

        // Initialize views
        lockedImageView = findViewById(R.id.lockedImageView)
        otpEditText = findViewById(R.id.otpEditText)
        submitButton2 = findViewById(R.id.submit2btn)
        loaderImageView = findViewById(R.id.loaderImageView)
        unlockedImageView = findViewById(R.id.unlockedImageView)

        // Set click listener for the submit button
        submitButton2.setOnClickListener {
            submitOTP()
        }

        // Load the loading GIF using Glide
        Glide.with(this)
            .load(R.drawable.loadinggif8) // Replace loading_gif with the actual resource ID of your GIF
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(loaderImageView)
    }

    private fun submitOTP() {
        val otp = otpEditText.text.toString()

        // Show loader image and hide locked image
        loaderImageView.visibility = View.VISIBLE
        lockedImageView.visibility = View.GONE

        // Simulate OTP verification process
        // Replace this code with your actual implementation that verifies the OTP
        // Here, I'm simulating a delay using a Handler to demonstrate the loading process
        Handler(Looper.getMainLooper()).postDelayed({
            // Hide loader image and show unlocked image
            loaderImageView.visibility = View.GONE
            unlockedImageView.visibility = View.VISIBLE
        }, 2000) // Delay of 2 seconds
    }
}
