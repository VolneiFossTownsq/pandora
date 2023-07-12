package io.townsq.pandora.data.register
import io.townsq.pandora.data.models.Driver
import io.townsq.pandora.data.models.Register
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {

    @POST("/register")
    suspend fun postRegister(@Body userInfo: Register): Response<Driver>

}