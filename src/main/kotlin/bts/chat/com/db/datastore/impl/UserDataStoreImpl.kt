package bts.chat.com.db.datastore.impl

import bts.chat.com.auth.service.AuthService
import bts.chat.com.chat.model.Message
import bts.chat.com.db.datastore.UserDataStore
import bts.chat.com.db.datastore.dao.ChatsDao
import bts.chat.com.db.datastore.dao.UserEntity
import com.mongodb.client.model.Filters
import org.bson.BsonString
import org.bson.BsonValue
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.descending
import java.util.UUID

class UserDataStoreImpl(private val database: CoroutineDatabase): UserDataStore {
    private val users = database.getCollection<UserEntity>()
    private val chats = database.getCollection<ChatsDao>()

    override suspend fun getAllUsers(): List<UserEntity> {
       val userDetails = users.find()
       return userDetails.toList()
    }

    override suspend fun getChatHistory(userId:String): List<ChatsDao> {
        val messageHistory = chats.find(Filters.eq("messageFrom", userId))
        return messageHistory.toList()
    }

    override suspend fun saveMessageToDb(message: ChatsDao): String? {
        chats.insertOne(message).insertedId
        return UUID.randomUUID().toString()
    }
}