package bts.chat.com.chat.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class Message(
    @BsonId
    val id: String = ObjectId().toString(),
    val messageText: String,
    val latLng: Location,
    val userName: String,
    val timeStamp: Long,
    val lastSeen: Long,
    val messageFrom: String,
    val messageTo: String
)

@Serializable
data class Location(
    val latitude: Float,
    val longitude: Float
)