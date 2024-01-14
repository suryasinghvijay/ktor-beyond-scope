package bts.chat.com.db.datastore

import bts.chat.com.db.datastore.dao.UserEntity

interface AuthDataStore {
    suspend fun findUserByEmail(email: String, userName: String) : UserEntity?
    suspend fun insert(user: UserEntity) : UserEntity
}