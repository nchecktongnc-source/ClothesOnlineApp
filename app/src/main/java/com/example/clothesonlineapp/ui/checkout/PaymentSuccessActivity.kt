package com.example.clothesonlineapp.ui.checkout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.databinding.ActivityPaymentSuccessBinding

class PaymentSuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            ActivityPaymentSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}