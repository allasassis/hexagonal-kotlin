package com.allas.hexagonal.application.ports.out

import com.allas.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun find(zipCode: String): Address
}