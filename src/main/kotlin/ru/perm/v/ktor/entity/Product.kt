package ru.perm.v.ktor.entity

data class Product(
    val id: Long = 0,
    val name: String = "",
    val description: String = "",
    val price: Double = 0.0
)
