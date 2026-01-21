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
) : RecyclerView.Adapter<CartAdapter.VH>() {

    inner class VH(val binding: ItemCartBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemCartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]

        holder.binding.imgProduct.setImageResource(item.product.imageRes)
        holder.binding.txtName.text = item.product.name
        holder.binding.txtPrice.text = "$${item.product.price}"
        holder.binding.txtQty.text = item.qty.toString()

        holder.binding.btnPlus.setOnClickListener {
            CartManager.increase(item)
            notifyItemChanged(position)
            onUpdate()
        }

        holder.binding.btnMinus.setOnClickListener {
            CartManager.decrease(item)
            notifyDataSetChanged()
            onUpdate()
        }
    }

    override fun getItemCount() = items.size
}