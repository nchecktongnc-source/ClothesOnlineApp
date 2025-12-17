package com.example.clothesonlineapp.ui.cart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.databinding.ActivityCartBinding
import com.example.clothesonlineapp.utils.CartManager

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = CartManager.getCartItems()
        val text = items.joinToString("\n") {
            "${it.name} - $${it.price}"
        }

        binding.tvItems.text = text
        binding.tvTotal.text = "Total: $${CartManager.getTotalPrice()}"
    }
}
