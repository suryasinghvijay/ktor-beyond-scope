package bts.chat.com.db.datastore

import bts.chat.com.auth.service.AuthService
import bts.chat.com.chat.model.Message
import bts.chat.com.db.datastore.dao.ChatsDao
import bts.chat.com.db.datastore.dao.UserEntity

interface UserDataStore {

    suspend fun getAllUsers(): List<UserEntity>

    suspend fun getChatHistory(userId:String) : List<ChatsDao>
}