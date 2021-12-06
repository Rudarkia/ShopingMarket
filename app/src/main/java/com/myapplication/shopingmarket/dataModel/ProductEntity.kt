package com.myapplication.shopingmarket.dataModel

class ProductEntity internal constructor(
    val id: String,
    val category: String,
    val discontinued: Boolean,
    val image: String,
    val title_en: String,
    val title_es: String,
    val price: Double,
    val maxQ: Double,
    val stock: Double,
    val score: Double,
    val description: String
)