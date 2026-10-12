package ru.perm.v.ktor.dto

class ProductRepository {
    private val products = listOf(ProductDto(1, "name1"), ProductDto(2, "name2"))

    fun getAll(): List<ProductDto> {
        return products
    }

    fun getById(id: Long): ProductDto {
        return products.find { it.id == id }
            ?: ProductDto(id, "name$id")
    }
}
