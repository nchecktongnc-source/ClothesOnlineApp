package com.example.clothesonlineapp.ui.cart

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.utils.CartManager

class CartFragment : Fragment(R.layout.fragment_cart) {

    private lateinit var txtTotal: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerCart)
        val emptyLayout = view.findViewById<View>(R.id.emptyLayout)
        val btnCheckout = view.findViewById<Button>(R.id.btnCheckout)
        txtTotal = view.findViewById(R.id.txtTotal)

        recycler.layoutManager = LinearLayoutManager(requireContext())

        val adapter = CartAdapter(
            CartManager.getItems()
        ) {
            updateUI(recycler, emptyLayout)
            updateTotal() // ✅ IMPORTANT
        }

        recycler.adapter = adapter

        updateUI(recycler, emptyLayout)
        updateTotal() // ✅ FIRST LOAD
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

    private fun updateTotal() {
        val total = CartManager.totalPrice()
        txtTotal.text = "Total: $${"%.2f".format(total)}"
    }
}