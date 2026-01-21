package com.example.clothesonlineapp.ui.checkout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.utils.CartManager

class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        findViewById<Button>(R.id.btnPay).setOnClickListener {
            CartManager.clear()
            startActivity(Intent(this, PaymentSuccessActivity::class.java))
            finish()
        }
    }
}