package io.townsq.pandora.data

data class Vehicle(
    val id: String,
    val name: String,
    val licensePlate: String,
    val driver: Driver
)
