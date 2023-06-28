package io.townsq.pandora.data.models

enum class RecordType(val type: String, val queryValue: String) {
    MAINTENANCE("Maintenance", "maintenance"),
    SHIFT_START("Shift start", "shiftStart"),
    SHIFT_END("Shift end", "shiftEnd"),
    GAS("Gas", "gas")
}