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

        // ✅ SAFE product receive (prevents crash)
        val product = intent.getSerializableExtra("product") as? Product
        if (product == null) {
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

        // Bind data
        img.setImageResource(product.image)
        name.text = product.name
        price.text = "$${product.price}"
        qtyText.text = qty.toString()

        // ➕ Increase
        btnPlus.setOnClickListener {
            qty++
            qtyText.text = qty.toString()
        }

        // ➖ Decrease (min = 1)
        btnMinus.setOnClickListener {
            if (qty > 1) {
                qty--
                qtyText.text = qty.toString()
            }
        }

        // 🛒 Add to Cart
        btnAdd.setOnClickListener {

            // Optional: require size selection
            if (sizeGroup.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Please select size", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            repeat(qty) {
                CartManager.add(product)
            }

            Toast.makeText(this, "Added $qty item(s) to cart", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}