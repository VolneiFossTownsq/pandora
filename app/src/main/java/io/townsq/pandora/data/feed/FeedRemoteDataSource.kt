package io.townsq.pandora.data.feed

import io.townsq.pandora.data.models.Record
import java.io.IOException

class FeedRemoteDataSource(private val feedService: FeedService) {

    suspend fun getRecords(driverId: String, recordType: String? = null): Result<List<Record>> {
        return try {
            val response = feedService.getRecords(driverId = driverId, recordType = recordType)
            if (response.isSuccessful) {
                Result.success(response.body().orEmpty())
            } else {
                Result.failure(IOException("An error occurred while fetching your data"))
            }
        } catch (exception: Exception) {
            throw IOException()
        }
    }
}
