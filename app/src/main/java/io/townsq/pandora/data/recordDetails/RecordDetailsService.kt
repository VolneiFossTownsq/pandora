package io.townsq.pandora.data.recordDetails

import io.townsq.pandora.data.models.Record
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecordDetailsService {

    @GET("record")
    suspend fun getRecordById(@Query("recordId") recordId: String): Response<Record>

}
