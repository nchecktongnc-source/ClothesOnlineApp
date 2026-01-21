package com.example.clothesonlineapp.ui.checkout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.databinding.ActivityCheckoutBinding
import com.example.clothesonlineapp.utils.CartManager

class CheckoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheckoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtTotal.text =
            "Total: $${CartManager.getTotalPrice()}"

        binding.btnPay.setOnClickListener {
            CartManager.clear()
            startActivity(
                Intent(this, PaymentSuccessActivity::class.java)
            )
            finish()
        }
    }
}