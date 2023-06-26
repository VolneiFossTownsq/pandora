package io.townsq.pandora.data

import java.util.Date

data class Record(
    val id: String,
    val recordType: RecordType,
    val vehicle: Vehicle,
    val recordDate: Date
)
