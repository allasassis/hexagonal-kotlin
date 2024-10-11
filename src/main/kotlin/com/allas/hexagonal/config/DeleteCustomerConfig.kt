package com.allas.hexagonal.config

import com.allas.hexagonal.adapters.out.*
import com.allas.hexagonal.application.core.usecase.DeleteCustomerUseCase
import com.allas.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.allas.hexagonal.application.core.usecase.InsertCustomerUseCase
import com.allas.hexagonal.application.core.usecase.UpdateCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerConfig {

    @Bean
    fun deleteCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        deleteCustomerAdapter: DeleteCustomerAdapter
    ) = DeleteCustomerUseCase(deleteCustomerAdapter, findCustomerByIdUseCase)
}