package bts.chat.com.chat.repository

import bts.chat.com.db.datastore.dao.ChatsDao
import bts.chat.com.db.datastore.dao.UserEntity

interface UserRepository {
   suspend fun fetchAllRegesteredUser(): List<UserEntity>
   suspend fun fetchChatHistoryForUser(userId: String):  List<ChatsDao>
   suspend fun saveMessageToDb(message: ChatsDao) :String?
}