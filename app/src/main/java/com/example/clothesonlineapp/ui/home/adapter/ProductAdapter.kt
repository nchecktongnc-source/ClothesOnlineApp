package com.example.clothesonlineapp.ui.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesonlineapp.databinding.ItemProductBinding
import com.example.clothesonlineapp.model.Product
import com.example.clothesonlineapp.ui.detail.DetailActivity

class ProductAdapter(
    private val products: List<Product>
) : RecyclerView.Adapter<ProductAdapter.VH>() {

    inner class VH(val binding: ItemProductBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val product = products[position]

        holder.binding.imgProduct.setImageResource(product.imageRes)
        holder.binding.txtName.text = product.name
        holder.binding.txtPrice.text = "$${product.price}"

        holder.binding.root.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra("product", product)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = products.size
}