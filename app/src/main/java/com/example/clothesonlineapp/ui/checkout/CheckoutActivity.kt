package com.example.clothesonlineapp.ui.checkout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.utils.CartManager

class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val txtTotal = findViewById<TextView>(R.id.txtTotal)
        val btnPay = findViewById<Button>(R.id.btnPay)

        txtTotal.text = "Total: $${CartManager.totalPrice()}"

        btnPay.setOnClickListener {
            startActivity(Intent(this, PaymentSuccessActivity::class.java))
            finish()
        }
    }
}