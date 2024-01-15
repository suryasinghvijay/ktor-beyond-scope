package bts.chat.com.chat

import bts.chat.com.auth.service.AuthService
import bts.chat.com.base.BtsResponse
import bts.chat.com.chat.service.UserService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Routing.chatEndPoint(authService: UserService) {

    get("/users/all") {
        val response = authService.fetchAllUser()
        call.respond(BtsResponse(response, true, 200, null))
    }

    get("/chat/history/") {
        val userId = call.request.queryParameters["userId"]
        userId?.let { id ->
           val messages =  authService.fetchChatHistoryForUser(id)
            call.respond(BtsResponse(messages, true, 200, null))
        }
    }



}