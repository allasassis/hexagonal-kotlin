package com.allas.hexagonal.adapters.out

import com.allas.hexagonal.adapters.out.repository.CustomerRepository
import com.allas.hexagonal.application.core.domain.Customer
import com.allas.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
): FindCustomerByIdOutputPort {

    override fun find(id: String): Customer? =
        customerRepository.findById(id).getOrNull().let {
            return it?.toCustomer()
            // if 'it' exists, then return toCustomer else returns null
        };
}