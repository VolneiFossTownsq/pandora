package io.townsq.pandora.data.login

import io.townsq.pandora.data.models.Driver
import io.townsq.pandora.data.models.Login
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {

    @Headers("Content-Type: application/json")
    @POST("login")
    suspend fun postLogin(@Body userData: Login): Response<Driver>

}