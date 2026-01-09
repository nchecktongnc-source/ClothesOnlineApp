package com.example.clothesonlineapp.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesonlineapp.databinding.ItemCartBinding
import com.example.clothesonlineapp.model.Product
import com.example.clothesonlineapp.utils.CartManager

class CartAdapter(
    private val items: MutableList<Product>
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCartBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCartBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = items[position]
        holder.binding.txtName.text = product.name
        holder.binding.txtPrice.text = "$${product.price}"

        holder.binding.btnRemove.setOnClickListener {
            CartManager.removeItem(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, items.size)
        }
    }

    override fun getItemCount() = items.size
}
