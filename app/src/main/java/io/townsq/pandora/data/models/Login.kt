package io.townsq.pandora.data.models

import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("document") val document: String,
    @SerializedName("password") val password: String
)
