package com.allas.hexagonal.adapters.out

import com.allas.hexagonal.adapters.out.repository.CustomerRepository
import com.allas.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.allas.hexagonal.application.core.domain.Customer
import com.allas.hexagonal.application.ports.out.InsertCustomerOutputPort
import com.allas.hexagonal.application.ports.out.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(
    private val customerRepository: CustomerRepository
): UpdateCustomerOutputPort {

    override fun update(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }


}