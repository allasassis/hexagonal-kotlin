package com.allas.hexagonal.config

import com.allas.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.allas.hexagonal.adapters.out.InsertCustomerAdapter
import com.allas.hexagonal.application.core.usecase.InsertCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomer(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerAdapter: InsertCustomerAdapter
    ) = InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter)
}