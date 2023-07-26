package io.townsq.pandora.data.feed

import io.townsq.pandora.data.models.Record
import java.io.IOException

class FeedRepository(private val feedRemoteDataSource: FeedRemoteDataSource) {

    suspend fun getRecords(driverId: String, recordType: String? = null): Result<List<Record>> =
        feedRemoteDataSource.getRecords(driverId = driverId, recordType = recordType)


}
