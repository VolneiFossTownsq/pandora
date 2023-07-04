package io.townsq.pandora.data.feed

class FeedRepository(private val feedRemoteDataSource: FeedRemoteDataSource) {

    suspend fun getRecords(recordType: String? = null) = feedRemoteDataSource.getRecords(recordType ?: null)

}
