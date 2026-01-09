package com.example.clothesonlineapp.ui.checkout

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

        val total = CartManager.totalPrice()
        binding.txtTotal.text = "Total: $${total}"

        binding.btnCheckout.setOnClickListener {
            CartManager.clear()
            finish()
        }
    }
}
