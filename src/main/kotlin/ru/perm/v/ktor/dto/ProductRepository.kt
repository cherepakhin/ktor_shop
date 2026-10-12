package ru.perm.v.ktor.dto

import ru.perm.v.ktor.entity.Product

class ProductRepository {
    private val products = listOf(
        Product(1, "name1", "Product 1", 10.0),
        Product(2, "name2", "Product 2", 20.0)
    )

    fun getAll(): List<Product> {
        return products
    }

    fun getById(id: Long): Product {
        return products.find { it.id == id }
            ?: Product(id, "name$id", "", 0.0)
    }
}
