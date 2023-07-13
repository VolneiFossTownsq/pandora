package io.townsq.pandora.data.record

import io.townsq.pandora.data.models.Record
import io.townsq.pandora.data.models.Vehicle
import java.io.IOException

class RecordRemoteDataSource(private val recordService: RecordService) {

    suspend fun getVehiclesByDriverId(driverId: String): Result<Vehicle?> {
        return try {
            val response = recordService.getVehiclesByDriverId(driverId)
            if (response.isSuccessful){
                Result.success(response.body())
            }else{
                throw IOException()
            }
        }catch (exception: Exception){
            Result.failure(IOException("An error occurred while fetching your data"))
        }
    }

}