
package com.example.kritilabs

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class LockConnectionActivity : AppCompatActivity() {
    private lateinit var lockedImageView: ImageView
    private lateinit var otpEditText: EditText
    private lateinit var submitButton2: Button
    private lateinit var loaderImageView: ImageView
    private lateinit var unlockedImageView: ImageView
    private lateinit var errorMessageTextView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lockconnection)

        // Initialize views
        lockedImageView = findViewById(R.id.lockedImageView)
        otpEditText = findViewById(R.id.otpEditText)
        submitButton2 = findViewById(R.id.submit2btn)
        loaderImageView = findViewById(R.id.loaderImageView)
        unlockedImageView = findViewById(R.id.unlockedImageView)
        errorMessageTextView2 = findViewById(R.id.errorMessage2)

        // Set click listener for the submit button
        submitButton2.setOnClickListener {
            submitOTP()
        }

        // Load the loading GIF using Glide
        Glide.with(this)
            .load(R.drawable.loadinggif8) // Replace loading_gif with the actual resource ID of your GIF
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(loaderImageView)

        // Set input type for otpEditText to numeric
        otpEditText.inputType = android.text.InputType.TYPE_CLASS_NUMBER

        // Set TextWatcher for the otpEditText to mask the entered OTP with asterisks (*)
        otpEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // Temporarily remove the TextWatcher to prevent infinite loops
                otpEditText.removeTextChangedListener(this)

                // Mask the entered OTP with asterisks (*)
                val otpLength = s?.length ?: 0
                val maskedOTP = "*".repeat(otpLength)
                otpEditText.setText(maskedOTP)
                otpEditText.setSelection(otpLength) // Set cursor position to the end

                // Re-add the TextWatcher after updating the text
                otpEditText.addTextChangedListener(this)
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun submitOTP() {
        // Retrieve the original OTP entered by the user (without asterisks)
        val enteredOTP = otpEditText.text.toString()

        if (enteredOTP.isEmpty()) {
            // Show error message if the OTP is empty (not entered by the user)
            errorMessageTextView2.visibility = TextView.VISIBLE
            loaderImageView.visibility = View.GONE
            unlockedImageView.visibility = View.GONE
        } else {
            // Show loader image to simulate OTP verification delay
            loaderImageView.visibility = View.VISIBLE
            lockedImageView.visibility = View.GONE // Hide the locked image
            unlockedImageView.visibility = View.GONE // Hide the unlocked image
            errorMessageTextView2.visibility = View.GONE // Hide the error message

            // Simulate OTP verification
            Handler(Looper.getMainLooper()).postDelayed({
                // Hide loader image and show unlocked image after the verification is done
                loaderImageView.visibility = View.GONE
                lockedImageView.visibility = View.GONE // Hide the locked image
                unlockedImageView.visibility = View.VISIBLE // Show the unlocked image
            }, 2000) // Delay of 2 seconds to simulate OTP verification
        }
    }
}

