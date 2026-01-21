package com.example.clothesonlineapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val name: String,
    val price: Double,
    val image: Int
) : Parcelable