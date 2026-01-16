package com.example.clothesonlineapp.ui.checkout

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.utils.CartManager

class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val tvTotal = findViewById<TextView>(R.id.tvTotal)

        tvTotal.text = "$${CartManager.getTotalPrice()}"

        CartManager.clearCart()
        Toast.makeText(this, "Order placed!", Toast.LENGTH_SHORT).show()
    }
}