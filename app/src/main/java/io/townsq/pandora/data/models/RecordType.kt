package io.townsq.pandora.data.models

enum class RecordType(val type: String, val queryValue: String) {
    MAINTENANCE("Maintenance", "maintenance"),
    SHIFT("Shift", "shift"),
    GAS("Gas", "gas")
}