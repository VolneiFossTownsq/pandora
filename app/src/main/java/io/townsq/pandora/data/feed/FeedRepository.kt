package io.townsq.pandora.data.feed

import io.townsq.pandora.data.models.Record

class FeedRepository(private val feedRemoteDataSource: FeedRemoteDataSource) {

    suspend fun getRecords(recordType: String? = null): Result<List<Record>> = feedRemoteDataSource.getRecords(
        recordType ?: null
    )
}
