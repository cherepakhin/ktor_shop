package ru.perm.v.ktor.dto

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

object MapperProduct {
    private val objectMapper: ObjectMapper = jacksonObjectMapper()

    @JvmStatic
    fun toJSON(product: ProductDto): String {
        return objectMapper.writeValueAsString(product)
    }

    @JvmStatic
    fun fromJSON(json: String): ProductDto {
        return objectMapper.readValue(json, ProductDto::class.java)
    }
}