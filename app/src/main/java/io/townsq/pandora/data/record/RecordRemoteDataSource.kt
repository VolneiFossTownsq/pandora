package io.townsq.pandora.data.record

import android.util.Log
import io.townsq.pandora.data.models.CreateRecord
import io.townsq.pandora.data.models.Vehicle
import java.io.IOException

class RecordRemoteDataSource(private val recordService: RecordService) {

    suspend fun getVehiclesByDriverId(driverId: String): Result<Vehicle?> {
        return try {
            val response = recordService.getVehiclesByDriverId(driverId)

            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(IOException("An error occurred while fetching your data"))
            }
        } catch (exception: Exception) {

            throw IOException()
        }
    }

    suspend fun postCreateRecord(recordData: CreateRecord): Result<Unit?> {
        return try {
            val response = recordService.createRecord(recordData)

            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(IOException("Is not possible to create a new record"))
            }
        } catch (exception: Exception) {

            throw IOException()
        }
    }
}
