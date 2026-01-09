package com.example.clothesonlineapp.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clothesonlineapp.databinding.ActivityHomeBinding
import com.example.clothesonlineapp.ui.detail.DetailActivity
import com.example.clothesonlineapp.data.source.DummyData
import com.example.clothesonlineapp.ui.home.adapter.ProductAdapter

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ProductAdapter(DummyData.getProducts()) { product ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", product.name)
            intent.putExtra("price", product.price)
            intent.putExtra("image", product.imageRes)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}
