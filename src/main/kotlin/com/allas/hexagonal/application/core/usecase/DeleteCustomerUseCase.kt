package com.allas.hexagonal.application.core.usecase

import com.allas.hexagonal.application.ports.`in`.DeleteCustomerInputPort
import com.allas.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.allas.hexagonal.application.ports.out.DeleteCustomerOutputPort

class DeleteCustomerUseCase(
    private val deleteCustomerOutputPort: DeleteCustomerOutputPort,
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort
): DeleteCustomerInputPort {

    override fun delete(id: String) {
        findCustomerByIdInputPort.find(id)
        deleteCustomerOutputPort.delete(id)
    }
}