package com.example.clothesonlineapp.ui.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.databinding.ActivityDashboardBinding
import com.example.clothesonlineapp.model.Product
import com.example.clothesonlineapp.ui.detail.DetailActivity

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val products = listOf(
            Product(1, "T-Shirt", 15.0),
            Product(2, "Jacket", 45.0),
            Product(3, "Jeans", 30.0)
        )

        binding.btnProduct1.setOnClickListener {
            openDetail(products[0])
        }

        binding.btnProduct2.setOnClickListener {
            openDetail(products[1])
        }

        binding.btnProduct3.setOnClickListener {
            openDetail(products[2])
        }
    }

    private fun openDetail(product: Product) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("name", product.name)
        intent.putExtra("price", product.price)
        startActivity(intent)
    }
}
