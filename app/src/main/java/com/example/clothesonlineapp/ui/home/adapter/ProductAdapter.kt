package com.example.clothesonlineapp.ui.home.adapter

import android.content.Intent
import android.widget.Toast
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesonlineapp.databinding.ItemProductBinding
import com.example.clothesonlineapp.model.Product
import com.example.clothesonlineapp.ui.detail.DetailActivity
import com.example.clothesonlineapp.utils.CartManager

class ProductAdapter(
    private val items: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = items[position]

        holder.binding.txtName.text = product.name
        holder.binding.txtPrice.text = "$${product.price}"
        holder.binding.imgProduct.setImageResource(product.image)

        // 👉 CARD CLICK → Detail page
        holder.binding.root.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("product", product)
            holder.itemView.context.startActivity(intent)
        }

        // 👉 ADD TO CART BUTTON CLICK
        holder.binding.btnAddToCart.setOnClickListener {
            CartManager.add(product)
            Toast.makeText(
                holder.itemView.context,
                "${product.name} added to cart",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount() = items.size
}