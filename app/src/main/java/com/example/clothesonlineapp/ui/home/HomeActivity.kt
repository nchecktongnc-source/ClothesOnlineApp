package com.example.clothesonlineapp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.databinding.ActivityHomeBinding
import com.example.clothesonlineapp.model.Product
import com.example.clothesonlineapp.ui.home.adapter.ProductAdapter

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val products = listOf(
            Product(1, "T-Shirt", 15.0, R.drawable.tshirt),
            Product(2, "Jacket", 45.0, R.drawable.jacket),
            Product(3, "Jeans", 30.0, R.drawable.jeans),
            Product(4, "Black Tee", 18.0, R.drawable.tshirt),
            Product(5, "Green V-neck", 24.0, R.drawable.tshirt)
        )

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = ProductAdapter(products)
    }
}
