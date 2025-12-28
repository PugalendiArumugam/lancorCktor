//AuthModels.kt
package com.nexus.ktor.auth


import kotlinx.serialization.Serializable

@Serializable
data class OtpRequest(
    val email: String
)

@Serializable
data class OtpVerifyRequest(
    val email: String,
    val otp: String
)

@Serializable
data class AuthResponse(
    val success: Boolean,
    val message: String
)