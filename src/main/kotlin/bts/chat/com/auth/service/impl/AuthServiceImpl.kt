package bts.chat.com.auth.service.impl

import bts.chat.com.auth.exception.InvalidLoginCredentailException
import bts.chat.com.auth.exception.InvalidRequestException
import bts.chat.com.auth.exception.UserAlreadyExistsException
import bts.chat.com.auth.mappers.toUserEntity
import bts.chat.com.auth.model.User
import bts.chat.com.auth.model.request.LoginRequest
import bts.chat.com.auth.model.request.SignupRequest
import bts.chat.com.auth.repository.AuthRepository
import bts.chat.com.auth.service.AuthService
import bts.chat.com.db.datastore.dao.UserEntity
import java.util.*

class AuthServiceImpl(private val repository: AuthRepository) : AuthService {

    @Throws(InvalidRequestException::class)
    override fun validateSignupRequest(request: SignupRequest) {
        when {
            request.userName.isNullOrEmpty() -> throw InvalidRequestException("username can't be null or empty")
            request.password.isNullOrEmpty() -> throw InvalidRequestException("password can't be null or empty")
            request.email.isNullOrEmpty() -> throw InvalidRequestException("email can't be null or empty")
        }
    }

    @Throws(UserAlreadyExistsException::class)
    override suspend fun checkIfUserExist(request: SignupRequest) {
        val userEntity = repository.getUser(request.email.orEmpty(), request.userName.orEmpty())
        if (userEntity != null)
            throw UserAlreadyExistsException("user with similar email or userName already exist")

    }

    @Throws(InvalidLoginCredentailException::class)
    override suspend fun getUser(request: LoginRequest): UserEntity {
       return  repository.getUser(request.email.orEmpty(), request.email.orEmpty())
            ?: throw InvalidLoginCredentailException("invalid email or password")

    }

    override suspend fun saveUser(request: SignupRequest): User {
        return repository.insertUser(request.toUserEntity())
    }
}