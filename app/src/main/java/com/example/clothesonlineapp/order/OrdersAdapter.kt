package com.example.clothesonlineapp.order

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesonlineapp.R
import java.text.SimpleDateFormat
import java.util.*

class OrdersAdapter(
    private val orders: List<Order>
) : RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>() {

    class OrderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtTotal: TextView = view.findViewById(R.id.txtOrderTotal)
        val txtTime: TextView = view.findViewById(R.id.txtOrderTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]

        holder.txtTotal.text = "Total: $%.2f".format(order.total)

        val date = Date(order.timestamp)
        val formatter = SimpleDateFormat("dd MMM yyyy • HH:mm", Locale.getDefault())
        holder.txtTime.text = formatter.format(date)
    }

    override fun getItemCount() = orders.size
}