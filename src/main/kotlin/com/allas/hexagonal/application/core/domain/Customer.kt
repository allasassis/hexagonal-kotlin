package com.allas.hexagonal.application.core.domain

data class Customer(
    val id: String? = null,
    var name: String,
    var address: Address? = null,
    val cpf: String,
    val isValidCpf: Boolean = false
)
