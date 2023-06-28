package io.townsq.pandora.data.models

data class Vehicle(
    val id: String,
    val name: String,
    val licensePlate: String,
    val driver: Driver
)
