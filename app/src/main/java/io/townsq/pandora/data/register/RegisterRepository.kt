package io.townsq.pandora.data.register

import io.townsq.pandora.data.models.Driver
import io.townsq.pandora.data.models.Register

class RegisterRepository(private val registerRemoteDataSource: RegisterRemoteDataSource) {

    suspend fun postRegister(userInfo: Register? = null): Result<Driver?> = registerRemoteDataSource.postRegister(
        userInfo ?: null
    )

}