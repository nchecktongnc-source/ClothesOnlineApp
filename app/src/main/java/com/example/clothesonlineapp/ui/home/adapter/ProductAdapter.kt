package com.example.clothesonlineapp.ui.home.adapter

import android.content.Intent
import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesonlineapp.*
import com.example.clothesonlineapp.data.model.Product
import com.example.clothesonlineapp.ui.detail.DetailActivity

class ProductAdapter(private val items: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.VH>() {

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imgProduct)
        val name: TextView = view.findViewById(R.id.txtName)
        val price: TextView = view.findViewById(R.id.txtPrice)
    }

    override fun onCreateViewHolder(p: ViewGroup, v: Int): VH {
        return VH(LayoutInflater.from(p.context)
            .inflate(R.layout.item_product, p, false))
    }

    override fun onBindViewHolder(h: VH, i: Int) {
        val p = items[i]
        h.img.setImageResource(p.imageRes)
        h.name.text = p.name
        h.price.text = "$${p.price}"

        h.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra("product", p)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = items.size
}