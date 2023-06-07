package io.townsq.pandora.data

data class Record(
    val id: String,
    val recordType: RecordType,
    val vehicle: Vehicle,
    val driver: Driver
)
