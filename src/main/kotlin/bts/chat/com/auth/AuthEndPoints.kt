package bts.chat.com.auth

import bts.chat.com.auth.exception.InvalidRequestException
import bts.chat.com.auth.exception.UserAlreadyExistsException
import bts.chat.com.auth.mappers.toUserEntity
import bts.chat.com.auth.model.User
import bts.chat.com.auth.model.request.SignupRequest
import bts.chat.com.auth.service.AuthService
import bts.chat.com.base.BtsResponse
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Routing.signupEndPoint(authService: AuthService) {
    post("/auth/signup") {
        val params = call.receiveParameters()
        val request = SignupRequest(params["userName"], params["email"], params["password"])
        try {
            authService.validateSignupRequest(request)
            authService.getUser(request)
            val newUserDetails = authService.saveUser(request)
            call.respond(BtsResponse<User>(newUserDetails, true, 200, null))
        } catch (invalidRequestException: InvalidRequestException) {
            call.respond(
                BtsResponse<Unit>(
                    null,
                    true,
                    200,
                    hashMapOf("error" to invalidRequestException.message.orEmpty())
                )
            )
            return@post
        } catch (userExistsException: UserAlreadyExistsException) {
            call.respond(
                BtsResponse<Unit>(
                    null,
                    true,
                    200,
                    hashMapOf("error" to userExistsException.message.orEmpty())
                )
            )
            return@post
        }
    }

}