package io.townsq.pandora.data.models

data class Record(
    val id: String,
    val recordType: RecordType,
    val vehicle: Vehicle,
    val recordDate: String,
    val serviceCost: Number
)
