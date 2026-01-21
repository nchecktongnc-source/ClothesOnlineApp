package com.example.clothesonlineapp.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesonlineapp.databinding.ItemCartBinding
import com.example.clothesonlineapp.model.CartItem
import com.example.clothesonlineapp.utils.CartManager

class CartAdapter(
    private val items: MutableList<CartItem>,
    private val onUpdate: () -> Unit
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCartBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        with(holder.binding) {
            txtName.text = item.product.name
            txtPrice.text = "$${item.product.price}"
            txtQty.text = item.qty.toString()
            imgProduct.setImageResource(item.product.image)

            btnPlus.setOnClickListener {
                CartManager.increase(item)
                notifyItemChanged(position)
                onUpdate()
            }

            btnMinus.setOnClickListener {
                CartManager.decrease(item)
                notifyDataSetChanged()
                onUpdate()
            }

        }
    }

    override fun getItemCount() = items.size
}