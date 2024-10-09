package com.allas.hexagonal.adapters.out

import com.allas.hexagonal.adapters.out.repository.CustomerRepository
import com.allas.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.allas.hexagonal.application.core.domain.Customer
import com.allas.hexagonal.application.ports.out.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository
): InsertCustomerOutputPort {

    override fun insert(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }


}