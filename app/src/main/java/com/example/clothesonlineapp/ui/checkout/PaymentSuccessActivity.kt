package com.example.clothesonlineapp.ui.checkout

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.utils.CartManager

class PaymentSuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_success)

        val icon = findViewById<ImageView>(R.id.imgSuccess)

        CartManager.clear()

        icon.scaleX = 0f
        icon.scaleY = 0f
        icon.animate()
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(500)
            .setInterpolator(OvershootInterpolator())
            .start()

        Handler(Looper.getMainLooper()).postDelayed({
            finishAffinity() // 🔥 back to home
        }, 1200)
    }
}