package bts.chat.com.db.datastore.impl

import bts.chat.com.db.datastore.AuthDataStore
import bts.chat.com.db.datastore.dao.UserEntity
import com.mongodb.client.model.Filters
import org.litote.kmongo.coroutine.CoroutineDatabase

class AuthDataStoreImpl(private val database: CoroutineDatabase) : AuthDataStore {
    private val users = database.getCollection<UserEntity>()

    override suspend fun findUserByEmail(email: String, userName: String): UserEntity? {
       return users.findOne(
            Filters.and(
                Filters.eq("email", email),
                Filters.eq("userName", userName)
            )
        )
    }

    override suspend fun insert(user: UserEntity): UserEntity {
         users.insertOne(user)
        return user
    }

}