package com.example.clothesonlineapp.ui.cart

import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.data.model.Product

class CartAdapter(private val items: List<Product>) :
    RecyclerView.Adapter<CartAdapter.VH>() {

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imgProduct)
        val name: TextView = view.findViewById(R.id.txtName)
        val price: TextView = view.findViewById(R.id.txtPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val product = items[position]
        holder.img.setImageResource(product.imageRes)
        holder.name.text = product.name
        holder.price.text = "$${product.price}"
    }

    override fun getItemCount() = items.size
}