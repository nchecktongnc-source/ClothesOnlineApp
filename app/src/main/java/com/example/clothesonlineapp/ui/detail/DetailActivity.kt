package com.example.clothesonlineapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.databinding.ActivityDetailBinding
import com.example.clothesonlineapp.model.Product
import com.example.clothesonlineapp.utils.CartManager

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name") ?: ""
        val price = intent.getDoubleExtra("price", 0.0)
        val image = intent.getIntExtra("image", 0)

        val product = Product(name, price, image)

        binding.txtName.text = name
        binding.txtPrice.text = "$$price"
        binding.imgProduct.setImageResource(image)

        binding.btnAddCart.setOnClickListener {
            CartManager.add(product)
        }
    }
}