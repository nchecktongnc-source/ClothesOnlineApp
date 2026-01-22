package com.example.clothesonlineapp.ui.cart

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.ui.checkout.CheckoutActivity
import com.example.clothesonlineapp.utils.CartManager

class CartFragment : Fragment(R.layout.fragment_cart) {

    private lateinit var recycler: RecyclerView
    private lateinit var emptyLayout: View
    private lateinit var txtTotal: TextView
    private lateinit var btnCheckout: Button
    private lateinit var adapter: CartAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.recyclerCart)
        emptyLayout = view.findViewById(R.id.emptyLayout)
        txtTotal = view.findViewById(R.id.txtTotal)
        btnCheckout = view.findViewById(R.id.btnCheckout)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        adapter = CartAdapter(CartManager.getItems()) { updateUI() }
        recycler.adapter = adapter

        btnCheckout.setOnClickListener {
            if (CartManager.getItems().isEmpty()) {
                Toast.makeText(requireContext(), "Cart is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // ✅ GO TO PAYMENT SCREEN
            startActivity(Intent(requireContext(), CheckoutActivity::class.java))
        }

        updateUI()
    }

    private fun updateUI() {
        val empty = CartManager.getItems().isEmpty()
        emptyLayout.visibility = if (empty) View.VISIBLE else View.GONE
        recycler.visibility = if (empty) View.GONE else View.VISIBLE
        txtTotal.text = "Total: $%.2f".format(CartManager.totalPrice())
        adapter.notifyDataSetChanged()
    }
}