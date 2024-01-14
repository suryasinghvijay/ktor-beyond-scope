package bts.chat.com.auth.model

import kotlinx.serialization.Serializable
import org.bson.types.ObjectId

@Serializable
data class User(
    val id: String? = null,
    val username: String? = null,
    val email: String? = null,
    val avatar: String? = null,
    val accessToken: String? = null
)