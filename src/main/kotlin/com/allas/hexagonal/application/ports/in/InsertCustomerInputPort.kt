package com.allas.hexagonal.application.ports.`in`

import com.allas.hexagonal.application.core.domain.Customer

interface InsertCustomerInputPort {

    fun insert (customer: Customer, zipCode: String)
}