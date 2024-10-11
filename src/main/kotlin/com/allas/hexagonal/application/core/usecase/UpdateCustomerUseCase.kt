package com.allas.hexagonal.application.core.usecase

import com.allas.hexagonal.application.core.domain.Customer
import com.allas.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.allas.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.allas.hexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase(
    private val findCustomerByIdUseCase: FindCustomerByIdUseCase,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort,
): UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String) {
        if (customer.id == null) throw IllegalArgumentException("Id field can't be null!")
        findCustomerByIdUseCase.find(customer.id)
        // if not found, it'll throw an exception

        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            updateCustomerOutputPort.update(it)
        }
    }
}