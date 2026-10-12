package ru.perm.v.ktor.dto

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class MapperProduct(private val objectMapper: ObjectMapper = jacksonObjectMapper()) {
    fun toJSON(product: ProductDto): String {
        return objectMapper.writeValueAsString(product)
    }

    fun fromJSON(json: String): ProductDto {
        return objectMapper.readValue(json, ProductDto::class.java)
    }
}