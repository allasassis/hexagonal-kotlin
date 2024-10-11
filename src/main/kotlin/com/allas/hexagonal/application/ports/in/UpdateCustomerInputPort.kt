package com.allas.hexagonal.application.ports.`in`

import com.allas.hexagonal.application.core.domain.Customer

interface UpdateCustomerInputPort {

    fun update (customer: Customer, zipCode: String)
}