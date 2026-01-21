package com.example.clothesonlineapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.databinding.FragmentHomeBinding
import com.example.clothesonlineapp.model.Product
import com.example.clothesonlineapp.ui.home.adapter.ProductAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentHomeBinding.bind(view)

        val products = listOf(
            Product("T-Shirt", 20.0, R.drawable.tshirt),
            Product("Hoodie", 35.0, R.drawable.jacket),
            Product("Jeans", 40.0, R.drawable.jeans)
        )

        binding.recyclerHome.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerHome.adapter = ProductAdapter(products)
    }
}