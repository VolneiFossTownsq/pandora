package io.townsq.pandora.ui.login.di

import io.townsq.pandora.data.login.LoginRemoteDataSource
import io.townsq.pandora.data.login.LoginRepository
import io.townsq.pandora.data.login.LoginService
import io.townsq.pandora.ui.login.AuthenticationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val loginModule = module {

    factory { get<Retrofit>().create(LoginService::class.java) as LoginService }
    factory { LoginRemoteDataSource(get()) }
    factory { LoginRepository(get()) }
    viewModel { AuthenticationViewModel(get()) }

}