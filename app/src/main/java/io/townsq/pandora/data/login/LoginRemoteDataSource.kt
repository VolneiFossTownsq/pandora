package io.townsq.pandora.data.login

import io.townsq.pandora.data.models.Driver
import io.townsq.pandora.data.models.Login
import java.io.IOException
import javax.security.auth.login.LoginException

class LoginRemoteDataSource(private val loginService: LoginService) {

    suspend fun postLogin(userInfo: Login?): Result<Driver?> {
        return try {
            val response = loginService.postLogin(userInfo ?: throw IllegalArgumentException("User info is missing"))
            if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Result.failure(LoginException("Wrong user info"))
            }
        } catch (e: IOException) {
            throw IOException()
        }
    }

}
