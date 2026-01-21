package com.example.clothesonlineapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.data.repository.ProductRepository
import com.example.clothesonlineapp.ui.home.adapter.ProductAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.activity_home, container, false)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerProducts)
        recycler.layoutManager = GridLayoutManager(requireContext(), 2)
        recycler.adapter = ProductAdapter(ProductRepository.getProducts())

        return view
    }
}