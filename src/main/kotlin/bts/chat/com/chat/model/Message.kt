package bts.chat.com.chat.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class Message(
    val messageText: String? = null,
    val latLng: Location? = null,
    val userName: String? = null,
    val messageFromUserId: String? = null,
    val messageToUserId: String? = null
)

@Serializable
data class Location(
    val latitude: Float?,
    val longitude: Float?
)