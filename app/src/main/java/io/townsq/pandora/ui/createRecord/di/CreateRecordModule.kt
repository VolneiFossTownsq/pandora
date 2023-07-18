package io.townsq.pandora.ui.createRecord.di

import io.townsq.pandora.data.record.RecordRemoteDataSource
import io.townsq.pandora.data.record.RecordRepository
import io.townsq.pandora.data.record.RecordService
import io.townsq.pandora.ui.createRecord.RecordViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val createRecordModule = module {
    factory { get<Retrofit>().create(RecordService::class.java) as RecordService }
    factory { RecordRemoteDataSource(get()) }
    factory { RecordRepository(get()) }
    viewModel { RecordViewModel(get()) }
}