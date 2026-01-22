package com.example.clothesonlineapp.data

import com.google.firebase.database.FirebaseDatabase

object FirebaseProvider {

    val db: FirebaseDatabase by lazy {
        FirebaseDatabase.getInstance(
            "https://clothesonlineapp-default-rtdb.asia-southeast1.firebasedatabase.app"
        )
    }
}