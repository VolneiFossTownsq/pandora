package io.townsq.pandora.data.models

data class CreateRecord(
    val recordType: RecordType,
    val vehicleId: String,
    val recordDate: String,
    val serviceCost: Float
)
