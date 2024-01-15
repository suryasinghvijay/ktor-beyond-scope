package bts.chat.com.auth.mappers

import bts.chat.com.auth.model.User
import bts.chat.com.auth.model.request.SignupRequest
import bts.chat.com.db.datastore.dao.UserEntity

fun SignupRequest.toUserEntity() = UserEntity(
    username = this.userName, password = this.password, email = this.email
)

fun UserEntity.toUser() = User(
    username = this.username, id = this.id, email = this.email
)