package com.example.clothesonlineapp.ui.detail

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.model.Product
import com.example.clothesonlineapp.utils.CartManager

class DetailActivity : AppCompatActivity() {

    private var qty = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val product = intent.getParcelableExtra<Product>("product")
            ?: run {
                Toast.makeText(this, "Product not found", Toast.LENGTH_SHORT).show()
                finish()
                return
            }

        val img = findViewById<ImageView>(R.id.imgProduct)
        val name = findViewById<TextView>(R.id.txtName)
        val price = findViewById<TextView>(R.id.txtPrice)
        val qtyText = findViewById<TextView>(R.id.txtQty)
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnAdd = findViewById<Button>(R.id.btnAddToCart)
        val sizeGroup = findViewById<RadioGroup>(R.id.sizeGroup)

        img.setImageResource(product.image)
        name.text = product.name
        price.text = "$${product.price}"

        btnPlus.setOnClickListener {
            qty++
            qtyText.text = qty.toString()
        }

        btnMinus.setOnClickListener {
            if (qty > 1) {
                qty--
                qtyText.text = qty.toString()
            }
        }

        btnAdd.setOnClickListener {
            if (sizeGroup.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Please select a size", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            repeat(qty) {
                CartManager.add(product)
            }

            Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}