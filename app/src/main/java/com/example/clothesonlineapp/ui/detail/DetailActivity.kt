package com.example.clothesonlineapp.ui.detail

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.data.model.Product
import com.example.clothesonlineapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("product", Product::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("product") as? Product
        }

        if (product == null) {
            finish()
            return
        }

        binding.imgProduct.setImageResource(product.imageRes)
        binding.txtName.text = product.name
        binding.txtPrice.text = "$${product.price}"
    }
}