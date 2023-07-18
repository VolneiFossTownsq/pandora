package io.townsq.pandora.data.record

import io.townsq.pandora.data.models.CreateRecord
import io.townsq.pandora.data.models.Vehicle

class RecordRepository(private val recordRemoteDataSource: RecordRemoteDataSource) {

    suspend fun getVehiclesByDriverId(driverId: String): Result<Vehicle?> =
        recordRemoteDataSource.getVehiclesByDriverId(driverId)

    suspend fun postCreateRecord(recordData: CreateRecord): Result<Unit?> =
        recordRemoteDataSource.postCreateRecord(recordData)

}