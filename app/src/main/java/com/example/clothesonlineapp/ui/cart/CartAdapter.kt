package com.example.clothesonlineapp.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesonlineapp.databinding.ItemCartBinding
import com.example.clothesonlineapp.model.CartItem
import com.example.clothesonlineapp.utils.CartManager

class CartAdapter(
    private val items: MutableList<CartItem>,
    private val onChange: () -> Unit
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root)

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

        holder.binding.imgProduct.setImageResource(item.product.image)
        holder.binding.txtName.text = item.product.name
        holder.binding.txtPrice.text = "$${item.product.price}"
        holder.binding.txtQty.text = item.qty.toString()

        // ➕ Increase
        holder.binding.btnPlus.setOnClickListener {
            CartManager.increase(item)
            notifyItemChanged(position)
            onChange()
        }

        // ➖ Decrease
        holder.binding.btnMinus.setOnClickListener {
            CartManager.decrease(item)
            notifyDataSetChanged()
            onChange()
        }

        // 🗑 Remove
        holder.binding.btnDelete.setOnClickListener {
            CartManager.remove(item)
            notifyDataSetChanged()
            onChange()
        }
    }

    override fun getItemCount() = items.size
}