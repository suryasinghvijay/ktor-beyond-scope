package bts.chat.com.auth.model.request

import kotlinx.serialization.Serializable

@Serializable
data class SignupRequest(
    val userName: String?= null,
    val email: String?= null,
    val password: String?= null
)
