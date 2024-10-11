package com.allas.hexagonal.adapters.out

import com.allas.hexagonal.adapters.out.repository.CustomerRepository
import com.allas.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.allas.hexagonal.application.core.domain.Customer
import com.allas.hexagonal.application.ports.out.DeleteCustomerOutputPort
import com.allas.hexagonal.application.ports.out.InsertCustomerOutputPort
import com.allas.hexagonal.application.ports.out.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class DeleteCustomerAdapter(
    private val customerRepository: CustomerRepository
): DeleteCustomerOutputPort {

    override fun delete(id: String) {
        customerRepository.deleteById(id)
    }
}