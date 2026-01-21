package com.example.clothesonlineapp.model

import java.io.Serializable

data class Product(
    val name: String,
    val price: Double,
    val image: Int
) : Serializable