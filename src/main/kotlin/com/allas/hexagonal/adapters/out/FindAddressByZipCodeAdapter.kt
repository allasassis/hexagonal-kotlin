package com.allas.hexagonal.adapters.out

import com.allas.hexagonal.adapters.out.client.FindAddressByZipCodeClient
import com.allas.hexagonal.application.core.domain.Address
import com.allas.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    private val findAddressByZipCodeClient: FindAddressByZipCodeClient
): FindAddressByZipCodeOutputPort {

    override fun find(zipCode: String): Address = findAddressByZipCodeClient.find(zipCode).toAddress()
}