package com.example.clothesonlineapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.databinding.FragmentHomeBinding
import com.example.clothesonlineapp.model.Product
import com.example.clothesonlineapp.ui.home.adapter.ProductAdapter
import com.google.firebase.database.FirebaseDatabase

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        // ✅ CORRECT DATABASE URL
        val database = FirebaseDatabase.getInstance(
            "https://clothesonlineapp-default-rtdb.asia-southeast1.firebasedatabase.app"
        )

        database.getReference("home_debug")
            .setValue(
                mapOf(
                    "status" to "home_connected",
                    "time" to System.currentTimeMillis()
                )
            )
            .addOnSuccessListener {
                Log.d("FIREBASE_HOME", "🔥 HOME WRITE SUCCESS")
            }
            .addOnFailureListener {
                Log.e("FIREBASE_HOME", "❌ HOME WRITE FAILED", it)
            }

        val products = listOf(
            Product("T-Shirt", 20.0, R.drawable.tshirt),
            Product("Hoodie", 35.0, R.drawable.jacket),
            Product("Jeans", 40.0, R.drawable.jeans)
        )

        binding.recyclerHome.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerHome.adapter = ProductAdapter(products)
    }
}