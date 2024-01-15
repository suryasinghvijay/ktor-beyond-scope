package bts.chat.com.db.datastore.dao

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class ChatsDao (
@BsonId
val id: String = ObjectId().toString(),
val messageText: String,
val latLng: MessageLocation,
val userName: String,
val timeStamp: Long,
val lastSeen: Long,
val messageFrom: String,
val messageTo: String
)

@Serializable
data class MessageLocation(
    val latitude: Float,
    val longitude: Float
)
