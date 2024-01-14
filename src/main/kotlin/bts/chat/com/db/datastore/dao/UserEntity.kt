package bts.chat.com.db.datastore.dao

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class UserEntity(
    @BsonId
    val id: String = ObjectId().toString(),
    val token: String? = null,
    val username: String? = null,
    val email: String? = null,
    val avatar: String? = null,
    val password: String? = null,
)
