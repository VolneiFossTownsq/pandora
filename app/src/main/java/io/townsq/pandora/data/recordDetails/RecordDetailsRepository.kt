package io.townsq.pandora.data.recordDetails

import io.townsq.pandora.data.models.Record

class RecordDetailsRepository(private val recordDetailsRemoteDataSource: RecordDetailsRemoteDataSource) {

    suspend fun getRecordById(recordId: String): Result<Record?> {
        return recordDetailsRemoteDataSource.getRecordById(recordId)
    }
}
