package io.townsq.pandora.ui.di

import io.townsq.pandora.ui.createRecord.RecordViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val recordListModule = module {
    factory { }
    factory { }
    factory { }
    viewModel { RecordViewModel() }
}
