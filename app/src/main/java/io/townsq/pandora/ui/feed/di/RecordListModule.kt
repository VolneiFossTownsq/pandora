package io.townsq.pandora.ui.feed.di

import io.townsq.pandora.data.feed.FeedRemoteDataSource
import io.townsq.pandora.data.feed.FeedRepository
import io.townsq.pandora.data.feed.FeedService
import io.townsq.pandora.ui.createRecord.RecordViewModel
import io.townsq.pandora.ui.feed.FeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val recordListModule = module {
    factory { get<Retrofit>().create(FeedService::class.java) as FeedService }
    factory { FeedRemoteDataSource(get()) }
    factory { FeedRepository(get()) }
    viewModel { FeedViewModel(get()) }
    viewModel { RecordViewModel(get()) }
}
