package bts.chat.com.chat.service.impl

import bts.chat.com.chat.repository.UserRepository
import bts.chat.com.chat.service.UserService
import bts.chat.com.db.datastore.dao.UserEntity

class UserServiceImpl(val repository: UserRepository): UserService {
    override suspend fun fetchAllUser(): List<UserEntity> {
        return  repository.fetchAllRegesteredUser()
    }

    override suspend fun fetchChatHistoryForUser(userId: String) {
        repository.fetchChatHistoryForUser(userId)
    }
}