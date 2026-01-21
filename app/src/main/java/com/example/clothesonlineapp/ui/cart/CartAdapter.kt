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

    inner class ViewHolder(val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.binding.txtName.text = item.product.name
        holder.binding.txtPrice.text = "$${item.product.price}"
        holder.binding.txtQty.text = item.qty.toString()
        holder.binding.imgProduct.setImageResource(item.product.image)

        holder.binding.btnPlus.setOnClickListener {
            CartManager.increase(item)
            refresh()
        }

        holder.binding.btnMinus.setOnClickListener {
            CartManager.decrease(item)
            refresh()
        }
    }

    private fun refresh() {
        items.clear()
        items.addAll(CartManager.getItems())
        notifyDataSetChanged()
        onUpdate()
    }

    override fun getItemCount() = items.size
}