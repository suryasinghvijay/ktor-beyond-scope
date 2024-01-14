package bts.chat.com.base

import kotlinx.serialization.Serializable

@Serializable
data class BtsResponse<T> (
    val data: T ?= null,
    val status: Boolean,
    val statusCode: Int,
    val error: HashMap<String, String> ?= null
)
