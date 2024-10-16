package com.allas.hexagonal.adapters.`in`.controller

import com.allas.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.allas.hexagonal.adapters.`in`.controller.response.CustomerResponse
import com.allas.hexagonal.application.core.domain.Customer
import com.allas.hexagonal.application.ports.`in`.DeleteCustomerInputPort
import com.allas.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.allas.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.allas.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.allas.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val insertCustomerInputPort: InsertCustomerInputPort,
    private val updateCustomerInputPort: UpdateCustomerInputPort,
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val deleteCustomerInputPort: DeleteCustomerInputPort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@Valid @RequestBody customerRequest: CustomerRequest) {
        with(customerRequest) {
            val customer = Customer(name = name, cpf = cpf)
            insertCustomerInputPort.insert(customer, customerRequest.zipCode)
        }
    }

    @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @Valid @RequestBody customerRequest: CustomerRequest) {
        with(customerRequest) {
            val customer = Customer(id = id, name = name, cpf = cpf)
            updateCustomerInputPort.update(customer, zipCode)
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String): CustomerResponse {
        val customer = findCustomerByIdInputPort.find(id)
        return CustomerResponse(customer)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: String) {
        deleteCustomerInputPort.delete(id)
    }
}