package bts.chat.com.auth.repository.impl

import bts.chat.com.auth.mappers.toUser
import bts.chat.com.auth.model.User
import bts.chat.com.auth.repository.AuthRepository
import bts.chat.com.db.datastore.AuthDataStore
import bts.chat.com.db.datastore.dao.UserEntity
import java.util.UUID

class AuthRepositoryImpl(private val authDataStore: AuthDataStore) : AuthRepository {
    override suspend fun getUser(email: String, userName:String): UserEntity? {
        return authDataStore.findUserByEmail(email, userName)
    }

    override suspend fun insertUser(userEntity: UserEntity): User {
       return authDataStore.insert(userEntity).toUser()
    }
}