package io.townsq.pandora.ui.feed.di

import io.townsq.pandora.ui.feed.FeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val recordListModule = module {
    factory { }
    factory { }
    factory { }

    viewModel { FeedViewModel() }
}