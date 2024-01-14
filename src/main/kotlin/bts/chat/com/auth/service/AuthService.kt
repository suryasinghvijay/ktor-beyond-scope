package bts.chat.com.auth.service

import bts.chat.com.auth.exception.InvalidRequestException
import bts.chat.com.auth.model.User
import bts.chat.com.auth.model.request.SignupRequest

interface AuthService {
    fun signupService(request: SignupRequest)
    @Throws(InvalidRequestException::class) fun validateSignupRequest(request: SignupRequest)
    suspend fun getUser(request:SignupRequest)
    suspend fun saveUser(request: SignupRequest) :User
}