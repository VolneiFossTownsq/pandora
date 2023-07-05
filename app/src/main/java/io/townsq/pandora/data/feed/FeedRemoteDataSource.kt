package io.townsq.pandora.data.feed

import io.townsq.pandora.data.models.Record
import java.io.IOException

class FeedRemoteDataSource(private val feedService: FeedService) {

    suspend fun getRecords(recordType: String? = null): Result<List<Record>> {
        return try {
            val response = feedService.getRecords(recordType)
            if (response.isSuccessful) {
                Result.success(response.body().orEmpty())
            }
            Result.failure(IOException("Error on get method"))
        } catch (e: IOException) {
            Result.failure(IOException("Error on get method"))
        }
    }

}
