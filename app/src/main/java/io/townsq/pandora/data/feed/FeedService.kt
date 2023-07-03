package io.townsq.pandora.data.feed

import io.townsq.pandora.data.models.Record
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FeedService {
    @GET("record")
    suspend fun getRecords(@Query("recordType") recordType: String? = null): Response<List<Record>>
}
