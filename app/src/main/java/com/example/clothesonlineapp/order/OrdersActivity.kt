package com.example.clothesonlineapp.order

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clothesonlineapp.R
import com.google.firebase.database.*

class OrdersActivity : AppCompatActivity() {

    private val database by lazy {
        FirebaseDatabase.getInstance(
            "https://clothesonlineapp-default-rtdb.asia-southeast1.firebasedatabase.app"
        )
    }

    private val orders = mutableListOf<Order>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)

        val recycler = findViewById<RecyclerView>(R.id.recyclerOrders)
        recycler.layoutManager = LinearLayoutManager(this)
        val adapter = OrdersAdapter(orders)
        recycler.adapter = adapter

        database.getReference("orders")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    orders.clear()

                    for (child in snapshot.children) {
                        val order = child.getValue(Order::class.java)
                        if (order != null) {
                            orders.add(order)
                        }
                    }

                    orders.reverse() // newest first
                    adapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {}
            })
    }
}