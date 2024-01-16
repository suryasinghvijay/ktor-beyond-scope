package bts.chat.com.db.datastore.dao

import com.github.jershell.kbson.BsonClassDiscriminator
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class ChatsDao(
    @BsonId
    val id: String = ObjectId().toString(),
    val messageText: String? = null,
    val latLng: MessageLocation? = null,
    val userName: String? = null,
    val timeStamp: Long? = null,
    val messageFromUserId: String? = null,
    val messageToUserId: String? = null
)

@Serializable
data class MessageLocation(
    val latitude: Float?,
    val longitude: Float?
)
