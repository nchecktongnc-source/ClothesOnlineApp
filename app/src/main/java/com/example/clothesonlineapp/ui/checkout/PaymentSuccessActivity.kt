package com.example.clothesonlineapp.ui.checkout

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.ui.dashboard.DashboardActivity
import com.example.clothesonlineapp.utils.CartManager

class PaymentSuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_success)

        val imgSuccess = findViewById<ImageView>(R.id.imgSuccess)
        val txtTotal = findViewById<TextView>(R.id.txtTotal)
        val txtCountdown = findViewById<TextView>(R.id.txtCountdown)

        // 💰 Show total
        val total = intent.getDoubleExtra("total", 0.0)
        txtTotal.text = "Total: $%.2f".format(total)

        // ✅ Tick animation
        imgSuccess.scaleX = 0f
        imgSuccess.scaleY = 0f
        imgSuccess.alpha = 0f

        imgSuccess.animate()
            .scaleX(1f)
            .scaleY(1f)
            .alpha(1f)
            .setDuration(700)
            .setInterpolator(OvershootInterpolator())
            .start()

        // 🧹 Clear cart
        CartManager.clear()

        // ⏳ Countdown 3 → 2 → 1
        var seconds = 3
        txtCountdown.text = "Returning in $seconds"

        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                seconds--
                if (seconds > 0) {
                    txtCountdown.text = "Returning in $seconds"
                    handler.postDelayed(this, 1000)
                } else {
                    val intent = Intent(
                        this@PaymentSuccessActivity,
                        DashboardActivity::class.java
                    )
                    intent.flags =
                        Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    finish()
                }
            }
        }

        handler.postDelayed(runnable, 1000)
    }
}