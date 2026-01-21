package com.example.clothesonlineapp.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clothesonlineapp.databinding.FragmentCartBinding
import com.example.clothesonlineapp.utils.CartManager

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)

        binding.recyclerCart.layoutManager = LinearLayoutManager(requireContext())

        val adapter = CartAdapter(CartManager.getItems()) {
            updateUI()
        }

        binding.recyclerCart.adapter = adapter

        updateUI()

        binding.btnCheckout.setOnClickListener {
            // open CheckoutActivity
        }

        return binding.root
    }

    private fun updateUI() {
        val empty = CartManager.getItems().isEmpty()
        binding.txtEmpty.visibility = if (empty) View.VISIBLE else View.GONE
        binding.recyclerCart.visibility = if (empty) View.GONE else View.VISIBLE
        binding.txtTotal.text = "Total: $${CartManager.getTotalPrice()}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}