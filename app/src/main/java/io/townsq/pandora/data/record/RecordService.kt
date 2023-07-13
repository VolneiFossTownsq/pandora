package io.townsq.pandora.data.record

import io.townsq.pandora.data.models.CreateRecord
import io.townsq.pandora.data.models.Vehicle
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface RecordService {

    @GET("vehicle")
    suspend fun getVehiclesByDriverId(@Query("driverId") driverId: String): Response<Vehicle>

    @Headers("Content-Type: application/json")
    @POST("record")
    suspend fun createRecord(@Body recordData: CreateRecord)

}
