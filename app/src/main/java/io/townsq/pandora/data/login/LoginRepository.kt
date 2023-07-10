package io.townsq.pandora.data.login

import io.townsq.pandora.data.models.Driver
import io.townsq.pandora.data.models.Login
import io.townsq.pandora.data.models.Record

class LoginRepository(private val loginRemoteDataSource: LoginRemoteDataSource) {

    suspend fun postLogin(userInfo: Login? = null): Result<Driver?> = loginRemoteDataSource.postLogin(
        userInfo ?: null
    )

}