package com.example.clothesonlineapp.ui.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.order.OrdersActivity
import com.example.clothesonlineapp.ui.cart.CartFragment
import com.example.clothesonlineapp.ui.home.HomeFragment
import com.example.clothesonlineapp.utils.CartManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        // 🔥 DEFAULT HOME
        bottomNav.selectedItemId = R.id.nav_home
        openHome()

        updateCartBadge(bottomNav)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.nav_home -> {
                    openHome()
                    true
                }

                R.id.nav_cart -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, CartFragment())
                        .commit()
                    true
                }

                // 🧾 ORDERS → OPEN ACTIVITY
                R.id.nav_orders -> {
                    startActivity(
                        Intent(this, OrdersActivity::class.java)
                    )
                    false
                }

                else -> false
            }
        }
    }

    private fun openHome() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, HomeFragment())
            .commit()
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