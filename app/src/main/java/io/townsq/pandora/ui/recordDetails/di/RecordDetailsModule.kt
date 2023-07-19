package io.townsq.pandora.ui.recordDetails.di

import io.townsq.pandora.data.recordDetails.RecordDetailsRemoteDataSource
import io.townsq.pandora.data.recordDetails.RecordDetailsRepository
import io.townsq.pandora.data.recordDetails.RecordDetailsService
import io.townsq.pandora.ui.recordDetails.RecordDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val recordDetailsModule = module {
    factory { get<Retrofit>().create(RecordDetailsService::class.java) as RecordDetailsService }
    factory { RecordDetailsRemoteDataSource(get()) }
    factory { RecordDetailsRepository(get()) }
    viewModel { (recordId: String) -> RecordDetailsViewModel(get(), recordId = recordId) }
}