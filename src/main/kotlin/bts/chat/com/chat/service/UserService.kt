package bts.chat.com.chat.service

import bts.chat.com.auth.exception.InvalidLoginCredentailException
import bts.chat.com.auth.model.request.LoginRequest
import bts.chat.com.db.datastore.dao.UserEntity

interface UserService {
    suspend fun fetchAllUser(): List<UserEntity>
    suspend fun fetchChatHistoryForUser(userId: String)
}