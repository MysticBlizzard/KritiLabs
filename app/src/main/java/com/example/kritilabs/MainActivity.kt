package com.example.kritilabs

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var forgotPasswordTextView: TextView
    private lateinit var submitButton: Button
    private lateinit var errorMessageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        forgotPasswordTextView = findViewById(R.id.forgotpass)
        submitButton = findViewById(R.id.submitbtn)
        errorMessageTextView = findViewById(R.id.errorMessage)

        submitButton.setOnClickListener {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (isValidCredentials(username, password)) {
            // Open next activity/page after successful login
            openNextActivity()
        } else {
            errorMessageTextView.visibility = TextView.VISIBLE

            Handler().postDelayed({
                errorMessageTextView.visibility = TextView.INVISIBLE
            }, 2000) // Delay of 2 seconds to remove the error message
        }
    }
    forgotPasswordTextView.setOnClickListener{
        openForgotPasswordLink()
    }
}

private fun showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}


private fun isValidCredentials(username: String, password: String): Boolean {
    // Perform validation logic here
    // You can implement your own validation rules
    // For example, check if username and password are not empty
    return username.isNotBlank() && password.isNotBlank()
}

private fun openNextActivity() {
    // Replace NextActivity::class.java with the actual activity you want to open after successful login
    val intent = Intent(this,VehicleActivity::class.java)
    startActivity(intent)
    finish() // Optional: Finish the current activity to prevent the user from going back to the login page
}
private fun openForgotPasswordLink() {
    // Open the forgot password link (dummy link)
    val forgotPasswordLink = "https://www.example.com/forgot-password"
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(forgotPasswordLink))
    startActivity(intent)
}
}