package com.allas.hexagonal.config

import com.allas.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.allas.hexagonal.adapters.out.InsertCustomerAdapter
import com.allas.hexagonal.adapters.out.UpdateCustomerAdapter
import com.allas.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.allas.hexagonal.application.core.usecase.InsertCustomerUseCase
import com.allas.hexagonal.application.core.usecase.UpdateCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {

    @Bean
    fun updateCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter
    ) = UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter)
}