package bts.chat.com.auth.model.response

import bts.chat.com.auth.model.User
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val accessToken : String,
    val user:User
)
