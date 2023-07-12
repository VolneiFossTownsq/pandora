package io.townsq.pandora.data.register

import io.townsq.pandora.data.models.Driver
import io.townsq.pandora.data.models.Register

class RegisterRemoteDataSource(private val registerService: RegisterService) {

    suspend fun postRegister(userInfo: Register? = null): Result<Driver?> {
        return try {
            val response = registerService.postRegister(
                userInfo ?: throw IllegalArgumentException("Informações de registro nulas")
            )
            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(RegisterException("incorrect registration information"))
            }
        } catch (e: Exception) {
            Result.failure(RegisterException("An error occurred during registration: ${e.message}"))
        }
    }
}
