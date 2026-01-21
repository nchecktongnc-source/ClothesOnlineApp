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
import com.google.android.material.bottomnavigation.BottomNavigationView

class CartFragment : Fragment(R.layout.fragment_cart) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerCart)
        val emptyLayout = view.findViewById<View>(R.id.emptyLayout)
        val btnCheckout = view.findViewById<Button>(R.id.btnCheckout)
        val btnStartShopping = view.findViewById<Button>(R.id.btnStartShopping)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        val adapter = CartAdapter(CartManager.getItems()) {
            updateUI(recycler, emptyLayout)
        }
        recycler.adapter = adapter

        btnCheckout.setOnClickListener {
            startActivity(
                Intent(requireContext(), CheckoutActivity::class.java)
            )
        }

        btnStartShopping.setOnClickListener {
            requireActivity()
                .findViewById<BottomNavigationView>(R.id.bottomNav)
                .selectedItemId = R.id.nav_home
        }

        updateUI(recycler, emptyLayout)
    }

    private fun updateUI(recycler: RecyclerView, empty: View) {
        if (CartManager.getItems().isEmpty()) {
            recycler.visibility = View.GONE
            empty.visibility = View.VISIBLE
        } else {
            recycler.visibility = View.VISIBLE
            empty.visibility = View.GONE
        }
    }
}