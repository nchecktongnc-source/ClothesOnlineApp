package com.example.clothesonlineapp.ui.detail

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.data.model.Product
import com.example.clothesonlineapp.utils.CartManager

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val product = intent.getSerializableExtra("product") as Product

        findViewById<ImageView>(R.id.imgDetail).setImageResource(product.imageRes)
        findViewById<TextView>(R.id.txtName).text = product.name
        findViewById<TextView>(R.id.txtPrice).text = "$${product.price}"

        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            CartManager.add(product)
            Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show()
        }
    }
}