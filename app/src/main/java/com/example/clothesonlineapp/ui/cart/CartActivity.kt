package com.example.clothesonlineapp.ui.cart

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.utils.CartManager

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val recycler = findViewById<RecyclerView>(R.id.recyclerCart)
        val total = findViewById<TextView>(R.id.tvTotal)

        recycler.adapter = CartAdapter(CartManager.getItems())
        total.text = "Total: $${CartManager.getTotalPrice()}"
    }
}