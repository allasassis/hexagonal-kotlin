package com.allas.hexagonal.adapters.out.client.response

import com.allas.hexagonal.application.core.domain.Address

class AddressResponse(
    val street: String,
    val city: String,
    val state: String
) {

    constructor(address: Address): this(
        address.street,
        address.city,
        address.state
    )

    fun toAddress() = Address(street, city, state)
}