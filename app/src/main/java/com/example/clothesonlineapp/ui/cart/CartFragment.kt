package com.example.clothesonlineapp.ui.cart

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.ui.checkout.CheckoutActivity
import com.example.clothesonlineapp.utils.CartManager

class CartFragment : Fragment(R.layout.fragment_cart) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerCart)
        val btnCheckout = view.findViewById<Button>(R.id.btnCheckout)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        val adapter = CartAdapter(CartManager.getItems()) {
            recycler.adapter?.notifyDataSetChanged()
        }
        recycler.adapter = adapter

        btnCheckout.setOnClickListener {
            startActivity(Intent(requireContext(), CheckoutActivity::class.java))
        }
    }
}