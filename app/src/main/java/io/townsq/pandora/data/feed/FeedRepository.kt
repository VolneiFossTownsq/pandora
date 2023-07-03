package io.townsq.pandora.data.feed

import io.townsq.pandora.data.models.Record

class FeedRepository(private val feedRemoteDataSource: FeedRemoteDataSource) {
    suspend fun getRecords(recordType: String? = null): Result<List<Record>> {
        return if (recordType != null) {
            feedRemoteDataSource.getRecords(recordType)
        } else {
            feedRemoteDataSource.getRecords()
        }
    }
}
