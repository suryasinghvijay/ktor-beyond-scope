package bts.chat.com.auth.repository

import bts.chat.com.auth.model.User
import bts.chat.com.db.datastore.dao.UserEntity

interface AuthRepository {

   suspend fun getUser(email: String, userName: String): UserEntity?
   suspend fun insertUser(userEntity: UserEntity) : User
}