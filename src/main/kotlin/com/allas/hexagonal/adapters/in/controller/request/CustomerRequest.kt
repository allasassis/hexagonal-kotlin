package com.allas.hexagonal.adapters.`in`.controller.request

import jakarta.validation.constraints.NotBlank
import org.springframework.data.mongodb.core.mapping.Field

data class CustomerRequest(

    @field:NotBlank(message = "Name must not be blank")
    val name: String,
    @field:NotBlank(message = "CPF must not be blank")
    val cpf: String,
    @field:NotBlank(message = "ZipCode must not be blank")
    val zipCode: String
)
