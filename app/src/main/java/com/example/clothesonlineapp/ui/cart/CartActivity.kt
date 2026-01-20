package com.example.clothesonlineapp.ui.cart

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.ui.checkout.CheckoutActivity
import com.example.clothesonlineapp.utils.CartManager

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val recyclerCart = findViewById<RecyclerView>(R.id.recyclerCart)
        val txtTotal = findViewById<TextView>(R.id.txtTotal)
        val btnCheckout = findViewById<Button>(R.id.btnCheckout)

        recyclerCart.layoutManager = LinearLayoutManager(this)
        recyclerCart.adapter = CartAdapter(CartManager.getItems())

        // ✅ FIXED HERE
        txtTotal.text = "Total: $${CartManager.getTotalPrice()}"

        btnCheckout.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))
        }
    }
}