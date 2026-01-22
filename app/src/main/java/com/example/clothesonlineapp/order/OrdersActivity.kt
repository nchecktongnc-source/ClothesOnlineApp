package com.example.clothesonlineapp.order

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.R
import com.google.firebase.database.FirebaseDatabase

class OrdersActivity : AppCompatActivity() {

    private val database by lazy {
        FirebaseDatabase.getInstance(
            "https://clothesonlineapp-default-rtdb.asia-southeast1.firebasedatabase.app"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)

        val txtOrders = findViewById<TextView>(R.id.txtOrders)

        database.getReference("orders")
            .get()
            .addOnSuccessListener { snapshot ->
                if (!snapshot.exists()) {
                    txtOrders.text = "No orders yet"
                    return@addOnSuccessListener
                }

                val builder = StringBuilder()

                snapshot.children.forEach { order ->
                    val total = order.child("total").getValue(Double::class.java)
                    val time = order.child("timestamp").getValue(Long::class.java)

                    builder.append("🧾 Order\n")
                    builder.append("Total: $total\n")
                    builder.append("Time: $time\n\n")
                }

                txtOrders.text = builder.toString()
            }
            .addOnFailureListener {
                Log.e("ORDERS", "Failed to load orders", it)
                txtOrders.text = "Failed to load orders"
            }
    }
}