package com.allas.hexagonal.application.ports.out

import com.allas.hexagonal.application.core.domain.Customer

interface InsertCustomerOutputPort {

    fun insert(customer: Customer)
}