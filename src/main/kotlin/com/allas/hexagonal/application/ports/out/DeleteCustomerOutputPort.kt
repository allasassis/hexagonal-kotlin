package com.allas.hexagonal.application.ports.out

interface DeleteCustomerOutputPort {

    fun delete(id: String)
}