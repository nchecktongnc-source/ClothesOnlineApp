package com.example.clothesonlineapp.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.clothesonlineapp.data.repository.ProductRepository
import com.example.clothesonlineapp.databinding.ActivityHomeBinding
import com.example.clothesonlineapp.ui.detail.DetailActivity
import com.example.clothesonlineapp.ui.home.adapter.ProductAdapter

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val products = ProductRepository.getProducts()

        binding.recyclerProducts.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerProducts.adapter =
            ProductAdapter(products) { product ->
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("product", product)
                startActivity(intent)
            }
    }
}