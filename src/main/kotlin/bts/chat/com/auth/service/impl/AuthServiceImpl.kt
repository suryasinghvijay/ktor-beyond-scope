package bts.chat.com.auth.service.impl

import bts.chat.com.auth.exception.InvalidRequestException
import bts.chat.com.auth.exception.UserAlreadyExistsException
import bts.chat.com.auth.mappers.toUserEntity
import bts.chat.com.auth.model.User
import bts.chat.com.auth.model.request.SignupRequest
import bts.chat.com.auth.repository.AuthRepository
import bts.chat.com.auth.service.AuthService
import java.util.*

class AuthServiceImpl(private val repository: AuthRepository) : AuthService {
    override fun signupService(request: SignupRequest) {
        TODO("Not yet implemented")
    }

    @Throws(InvalidRequestException::class)
    override fun validateSignupRequest(request: SignupRequest) {
        when {
            request.userName.isNullOrEmpty() -> throw InvalidRequestException("username can't be null or empty")
            request.password.isNullOrEmpty() -> throw InvalidRequestException("password can't be null or empty")
            request.email.isNullOrEmpty() -> throw InvalidRequestException("email can't be null or empty")
        }
    }

    @Throws(UserAlreadyExistsException::class)
    override suspend fun getUser(request: SignupRequest) {
        val userEntity = repository.getUser(request.email.orEmpty(), request.userName.orEmpty())
        userEntity.run {
            throw UserAlreadyExistsException("user with similar email or userName already exist")

        }
    }

    override suspend fun saveUser(request: SignupRequest): User {
       return repository.insertUser(request.toUserEntity())
    }
}