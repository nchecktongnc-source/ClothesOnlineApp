package com.example.clothesonlineapp.data.model

import java.io.Serializable

data class Product(
    val name: String,
    val price: Double,
    val imageRes: Int
) : Serializable