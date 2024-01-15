package bts.chat.com.auth

import bts.chat.com.auth.exception.InvalidLoginCredentailException
import bts.chat.com.auth.exception.InvalidRequestException
import bts.chat.com.auth.exception.UserAlreadyExistsException
import bts.chat.com.auth.mappers.toUser
import bts.chat.com.auth.model.User
import bts.chat.com.auth.model.request.LoginRequest
import bts.chat.com.auth.model.request.SignupRequest
import bts.chat.com.auth.model.response.LoginResponse
import bts.chat.com.auth.service.AuthService
import bts.chat.com.base.BtsResponse
import bts.chat.com.failedResponse
import bts.chat.com.plugins.generateToken
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.authEndPoint(authService: AuthService) {
    post("/auth/signup") {
        val params = call.receiveParameters()
        val request = SignupRequest(params["userName"], params["email"], params["password"])
        try {
            authService.validateSignupRequest(request)
            authService.checkIfUserExist(request)
            val newUserDetails = authService.saveUser(request)
            call.respond(BtsResponse(newUserDetails, true, 200, null))
        } catch (invalidRequestException: InvalidRequestException) {
            failedResponse(invalidRequestException)
            return@post
        } catch (userExistsException: UserAlreadyExistsException) {
            failedResponse(userExistsException)
            return@post
        }
    }

    post("/auth/login") {
        val params = call.receiveParameters()
        if (!(params["email"].isNullOrEmpty() && params["password"].isNullOrEmpty())) {
            val loginRequest = LoginRequest(params["email"].orEmpty(), params["password"].orEmpty())
            try {
                val registeredUser = authService.getUser(loginRequest)
                if (registeredUser.password.equals(loginRequest.password)) {
                    val token = generateToken(registeredUser)
                    call.respond(
                        BtsResponse(
                            LoginResponse(accessToken = token, user = registeredUser.toUser()),
                            true,
                            200,
                            null
                        )
                    )
                }
            } catch (exception: InvalidLoginCredentailException) {
                failedResponse(exception)
                return@post
            }
        }

    }

}

