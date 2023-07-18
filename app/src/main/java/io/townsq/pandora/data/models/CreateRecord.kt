package io.townsq.pandora.data.models

data class CreateRecord(
    val recordType: String,
    val vehicleId: String,
    val recordDate: String,
    val serviceCost: Float?
)
