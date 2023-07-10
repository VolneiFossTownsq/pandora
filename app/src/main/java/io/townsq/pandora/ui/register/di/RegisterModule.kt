package io.townsq.pandora.ui.register.di

import io.townsq.pandora.data.register.RegisterRemoteDataSource
import io.townsq.pandora.data.register.RegisterRepository
import io.townsq.pandora.data.register.RegisterService
import io.townsq.pandora.ui.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val registeModule = module {

    factory { get<Retrofit>().create(RegisterService::class.java) as RegisterService }
    factory { RegisterRemoteDataSource(get()) }
    factory { RegisterRepository(get()) }
    viewModel { RegisterViewModel(get()) }

}