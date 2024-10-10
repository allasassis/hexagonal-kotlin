package com.allas.hexagonal.adapters.`in`.controller.response

import com.allas.hexagonal.adapters.out.client.response.AddressResponse
import com.allas.hexagonal.application.core.domain.Customer

data class CustomerResponse(
    val id: String,
    val name: String,
    val address: AddressResponse,
    val cpf: String,
    val isValidCpf: Boolean,
) {
    constructor(customer: Customer): this (
        customer.id!!, // here we can use !! because we're sure the entity will return from the DB with an ID
        customer.name,
        AddressResponse(customer.address!!),
        customer.cpf,
        customer.isValidCpf
    )
}
