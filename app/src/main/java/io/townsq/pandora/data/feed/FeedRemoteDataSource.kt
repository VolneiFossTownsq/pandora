package io.townsq.pandora.data.feed

import io.townsq.pandora.data.models.Record
import java.io.IOException

class FeedRemoteDataSource(private val feedService: FeedService) {

    suspend fun getRecords(recordType: String? = null): Result<List<Record>> {
        val response = feedService.getRecords(recordType)
        return if (response.isSuccessful) {
            Result.success(response.body().orEmpty())
        } else {
            Result.failure(IOException("Error on get method"))
        }
    }
}
