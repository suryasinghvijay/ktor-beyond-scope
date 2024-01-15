package bts.chat.com.auth.service

import bts.chat.com.auth.exception.InvalidLoginCredentailException
import bts.chat.com.auth.exception.InvalidRequestException
import bts.chat.com.auth.exception.UserAlreadyExistsException
import bts.chat.com.auth.model.User
import bts.chat.com.auth.model.request.LoginRequest
import bts.chat.com.auth.model.request.SignupRequest
import bts.chat.com.db.datastore.dao.UserEntity

interface AuthService {
    @Throws(InvalidRequestException::class)
    fun validateSignupRequest(request: SignupRequest)

    @Throws(UserAlreadyExistsException::class)
    suspend fun checkIfUserExist(request: SignupRequest)

    @Throws(InvalidLoginCredentailException::class)
    suspend fun getUser(request: LoginRequest): UserEntity
    suspend fun saveUser(request: SignupRequest): User
}