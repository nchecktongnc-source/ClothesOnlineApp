package com.example.clothesonlineapp.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.data.repository.ProductRepository
import com.example.clothesonlineapp.ui.cart.CartActivity
import com.example.clothesonlineapp.ui.home.adapter.ProductAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recycler = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerProducts)
        recycler.layoutManager = GridLayoutManager(this, 2)
        recycler.adapter = ProductAdapter(ProductRepository.getProducts())

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> true // already here

                R.id.nav_cart -> {
                    startActivity(Intent(this, CartActivity::class.java))
                    true
                }

                else -> false
            }
        }
    }
}