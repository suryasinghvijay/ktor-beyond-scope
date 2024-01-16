package bts.chat.com.chat.repository.impl

import bts.chat.com.chat.repository.UserRepository
import bts.chat.com.db.datastore.UserDataStore
import bts.chat.com.db.datastore.dao.ChatsDao
import bts.chat.com.db.datastore.dao.UserEntity
import org.bson.BsonString

class UserRepositoryImpl(val dataStore: UserDataStore) : UserRepository {
    override suspend fun fetchAllRegesteredUser(): List<UserEntity> {
        return dataStore.getAllUsers()
    }

    override suspend fun fetchChatHistoryForUser(userId: String): List<ChatsDao> {
        return dataStore.getChatHistory(userId)
    }

    override suspend fun saveMessageToDb(message: ChatsDao): String? {
        return dataStore.saveMessageToDb(message)
    }
}