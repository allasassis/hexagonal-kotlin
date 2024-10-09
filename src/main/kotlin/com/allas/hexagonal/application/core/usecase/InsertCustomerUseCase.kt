package com.allas.hexagonal.application.core.usecase

import com.allas.hexagonal.application.core.domain.Customer
import com.allas.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.allas.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.allas.hexagonal.application.ports.out.InsertCustomerOutputPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort
): InsertCustomerInputPort {

    // Unit is the void type of kotlin
    override fun insert(customer: Customer, zipCode: String) {
        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            insertCustomerOutputPort.insert(it)
            // it = customer
        }
    }
}