package com.example.clothesonlineapp.ui.cart

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.databinding.FragmentCartBinding
import com.example.clothesonlineapp.ui.checkout.CheckoutActivity
import com.example.clothesonlineapp.utils.CartManager

class CartFragment : Fragment(R.layout.fragment_cart) {

    private lateinit var binding: FragmentCartBinding
    private lateinit var adapter: CartAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCartBinding.bind(view)

        adapter = CartAdapter(
            CartManager.getItems().toMutableList()
        ) {
            updateTotal()
        }

        binding.recyclerCart.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerCart.adapter = adapter

        updateTotal()

        binding.btnCheckout.setOnClickListener {
            startActivity(
                Intent(requireContext(), CheckoutActivity::class.java)
            )
        }
    }

    private fun updateTotal() {
        binding.txtTotal.text = "Total: $${CartManager.getTotal()}"
    }
}