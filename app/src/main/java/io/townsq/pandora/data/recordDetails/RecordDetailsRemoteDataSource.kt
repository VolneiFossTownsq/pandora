package io.townsq.pandora.data.recordDetails

import io.townsq.pandora.data.models.Record
import java.io.IOException

class RecordDetailsRemoteDataSource(private val service: RecordDetailsService) {

    suspend fun getRecordById(recordId: String): Result<Record?> {
        return try {
            val response = service.getRecordById(recordId)
            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                throw IOException()
            }
        } catch (exception: Exception) {
            Result.failure(IOException("An error occurred while fetching your data"))
        }
    }

}