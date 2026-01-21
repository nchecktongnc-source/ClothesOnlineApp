package com.example.clothesonlineapp.ui.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.ui.cart.CartFragment
import com.example.clothesonlineapp.ui.home.HomeFragment
import com.example.clothesonlineapp.utils.CartManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        // 🔥 FORCE HOME TAB
        bottomNav.selectedItemId = R.id.nav_home

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, HomeFragment())
            .commit()

        updateCartBadge(bottomNav)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, HomeFragment())
                        .commit()
                    true
                }
                R.id.nav_cart -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, CartFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let {
            if (it.getBooleanExtra("go_home", false)) {
                val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
                bottomNav.selectedItemId = R.id.nav_home

                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, HomeFragment())
                    .commit()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        updateCartBadge(findViewById(R.id.bottomNav))
    }

    private fun updateCartBadge(bottomNav: BottomNavigationView) {
        val badge = bottomNav.getOrCreateBadge(R.id.nav_cart)
        val count = CartManager.getItems().sumOf { it.qty }

        badge.isVisible = count > 0
        badge.number = count
    }
}