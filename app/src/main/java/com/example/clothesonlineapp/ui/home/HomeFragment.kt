package com.example.clothesonlineapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.data.repository.ProductRepository
import com.example.clothesonlineapp.databinding.FragmentHomeBinding
import com.example.clothesonlineapp.ui.home.adapter.ProductAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        binding.recyclerHome.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerHome.adapter =
            ProductAdapter(ProductRepository.getProducts())
    }
}