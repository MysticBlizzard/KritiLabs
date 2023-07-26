package com.example.kritilabs

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class VehicleActivity : AppCompatActivity() {
    private lateinit var vehicleNumberEditText: EditText
    private lateinit var invoiceNumberEditText: EditText
    private lateinit var requestOtpButton: Button
    private lateinit var connectToLockButton: Button
    private lateinit var errorMessageTextView3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle)

        // Initialize views
        vehicleNumberEditText = findViewById(R.id.vhn)
        invoiceNumberEditText = findViewById(R.id.invno)
        requestOtpButton = findViewById(R.id.requestOtpButton)
        connectToLockButton = findViewById(R.id.connecttoLockButton)
        errorMessageTextView3= findViewById(R.id.errorMessage3)

        // Handle request OTP button click
        requestOtpButton.setOnClickListener {
            // Perform action for requesting OTP
            requestOTP()
        }

        // Handle ConnectToLock button click
        connectToLockButton.setOnClickListener {
            // Open LockConnectionActivity
            openLockConnectionActivity()
        }
    }



    private fun openLockConnectionActivity() {
        // Open LockConnectionActivity
        val intent = Intent(this, LockConnectionActivity::class.java)
        startActivity(intent)
    }

    private fun requestOTP() {
        // Retrieve the vehicle and invoice numbers entered by the user
        val vehicleNumber = vehicleNumberEditText.text.toString()
        val invoiceNumber = invoiceNumberEditText.text.toString()

        // Simulate OTP request by checking if the vehicle and invoice numbers are valid
        val otpRequestSuccessful = simulateOTPRequest(vehicleNumber, invoiceNumber)

        if (otpRequestSuccessful) {
            // OTP request successful
            // Perform any necessary actions, such as showing a success message or navigating to the next screen
        } else {
            // OTP request failed
            // Show an error message to the user
            Toast.makeText(this, "Incorrect credentials. Please try again.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun simulateOTPRequest(vehicleNumber: String, invoiceNumber: String): Boolean {
        // Simulate the OTP request by checking if the vehicle and invoice numbers are valid
        // Replace this code with your actual implementation that interacts with your backend service
        // This is just an example to demonstrate the flow
        return vehicleNumber.isNotEmpty() && invoiceNumber.isNotEmpty()
    }
}

