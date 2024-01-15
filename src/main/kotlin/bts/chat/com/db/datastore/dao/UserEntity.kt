package bts.chat.com.db.datastore.dao

import bts.chat.com.chat.model.Message
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class UserEntity(
    @BsonId
    val id: String = ObjectId().toString(),
    val username: String? = null,
    val email: String? = null,
    val password: String? = null,
    val lastMessage: Message? = null
)
