package com.allas.hexagonal.application.ports.`in`

import com.allas.hexagonal.application.core.domain.Customer

interface FindCustomerByIdInputPort {

    fun find(id: String): Customer
}