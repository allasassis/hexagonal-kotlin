package com.allas.hexagonal.adapters.out.client.response

import com.allas.hexagonal.application.core.domain.Address

class AddressResponse(
    val street: String,
    val city: String,
    val state: String
) {
    fun toAddress() = Address(street, city, state)
}