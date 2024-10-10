package com.allas.hexagonal.application.core.usecase

import com.allas.hexagonal.application.core.exceptions.ObjectNotFoundException
import com.allas.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.allas.hexagonal.application.ports.out.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort
): FindCustomerByIdInputPort {

    // ?: = if the value is null do this
    override fun find(id: String)
    = findCustomerByIdOutputPort.find(id) ?: throw ObjectNotFoundException("Customer not found")
}