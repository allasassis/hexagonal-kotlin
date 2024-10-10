package com.allas.hexagonal.config

import com.allas.hexagonal.adapters.out.FindCustomerByIdAdapter
import com.allas.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {

    @Bean
    fun findCustomerById(
        findCustomerByIdAdapter: FindCustomerByIdAdapter
    ) = FindCustomerByIdUseCase(findCustomerByIdAdapter)
}