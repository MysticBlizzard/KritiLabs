package com.example.kritilabs

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class VehicleActivity : AppCompatActivity() {
    private lateinit var vehicleNumberEditText: EditText
    private lateinit var invoiceNumberEditText: EditText
    private lateinit var requestOtpButton: Button
    private lateinit var connectToLockButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle)

        // Initialize views
        vehicleNumberEditText = findViewById(R.id.vhn)
        invoiceNumberEditText = findViewById(R.id.invno)
        requestOtpButton = findViewById(R.id.requestOtpButton)
        connectToLockButton = findViewById(R.id.connecttoLockButton)

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

        // TODO: Implement your logic to send an OTP request to the backend
        // You will need to integrate with your backend service or API here
        // This code is a placeholder and needs to be replaced with your actual implementation

        // Here, you can simulate a response from the backend
        val otpRequestSuccessful = simulateOTPRequest(vehicleNumber, invoiceNumber)

        if (otpRequestSuccessful) {
            // OTP request successful
            // Perform any necessary actions, such as showing a success message or navigating to the next screen
        } else {
            // OTP request failed
            // Handle the failure case, such as showing an error message or retrying the request
        }
    }

    private fun simulateOTPRequest(vehicleNumber: String, invoiceNumber: String): Boolean {
        // Simulate the OTP request by checking if the vehicle and invoice numbers are valid
        // Replace this code with your actual implementation that interacts with your backend service
        // This is just an example to demonstrate the flow
        return vehicleNumber.isNotEmpty() && invoiceNumber.isNotEmpty()
    }
}

