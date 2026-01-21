package com.example.clothesonlineapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.databinding.ActivityDetailBinding
import com.example.clothesonlineapp.model.Product
import com.example.clothesonlineapp.utils.CartManager

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.getParcelableExtra<Product>("product")!!

        binding.imgProduct.setImageResource(product.imageRes)
        binding.txtName.text = product.name
        binding.txtPrice.text = "$${product.price}"

        binding.btnAddCart.setOnClickListener {
            CartManager.add(product)
            finish()
        }
    }
}