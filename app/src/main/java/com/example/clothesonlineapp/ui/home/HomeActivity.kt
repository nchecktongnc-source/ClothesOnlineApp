package com.example.clothesonlineapp.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.databinding.ActivityHomeBinding
import com.example.clothesonlineapp.ui.dashboard.DashboardActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShopNow.setOnClickListener {
            startActivity(
                Intent(this, DashboardActivity::class.java)
            )
        }
    }
}
