package com.example.clothesonlineapp.ui.checkout

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.utils.CartManager
import com.google.firebase.database.FirebaseDatabase

class CheckoutActivity : AppCompatActivity() {

    // ✅ CORRECT DATABASE (asia-southeast1)
    private val database by lazy {
        FirebaseDatabase.getInstance(
            "https://clothesonlineapp-default-rtdb.asia-southeast1.firebasedatabase.app"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        // 🔥 TEST CONNECTION (YOU WILL SEE THIS IN FIREBASE)
        database.getReference("debug")
            .setValue(
                mapOf(
                    "status" to "connected",
                    "time" to System.currentTimeMillis()
                )
            )
            .addOnSuccessListener {
                Log.d("FIREBASE", "🔥 DEBUG WRITE SUCCESS")
            }
            .addOnFailureListener {
                Log.e("FIREBASE", "❌ DEBUG WRITE FAILED", it)
            }

        val txtTotal = findViewById<TextView>(R.id.txtTotal)
        val btnPay = findViewById<Button>(R.id.btnPay)

        val total = CartManager.totalPrice()
        txtTotal.text = "Total: $%.2f".format(total)

        btnPay.setOnClickListener {

            if (CartManager.getItems().isEmpty()) {
                Toast.makeText(this, "Cart is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 🔥 SAVE ORDER
            val orderData = mapOf(
                "total" to total,
                "timestamp" to System.currentTimeMillis(),
                "items" to CartManager.getItems().map {
                    mapOf(
                        "name" to it.product.name,
                        "price" to it.product.price,
                        "qty" to it.qty
                    )
                }
            )

            database.getReference("orders")
                .push()
                .setValue(orderData)
                .addOnSuccessListener {
                    Log.d("FIREBASE", "✅ ORDER SAVED")
                }
                .addOnFailureListener {
                    Log.e("FIREBASE", "❌ ORDER FAILED", it)
                }

            val intent = Intent(this, PaymentSuccessActivity::class.java)
            intent.putExtra("total", total)
            startActivity(intent)
            finish()
        }
    }
}