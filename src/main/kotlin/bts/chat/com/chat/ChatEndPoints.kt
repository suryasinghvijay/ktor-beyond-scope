package bts.chat.com.chat

import bts.chat.com.base.BtsResponse
import bts.chat.com.chat.model.Message
import bts.chat.com.chat.service.UserService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Routing.chatEndPoint(service: UserService) {

    get("/users/all") {
        val response = service.fetchAllUser()
        call.respond(BtsResponse(response, true, 200, null))
    }

    get("/chat/history/") {
        val userId = call.request.queryParameters["userId"]
        userId?.let { id ->
            val messages = service.fetchChatHistoryForUser(id)
            call.respond(BtsResponse(messages, true, 200, null))
        }
    }

    post("/chat/send") {
        val savedMessageId = service.saveMessageToDb(call.receive<Message>())
        call.respond(BtsResponse(savedMessageId, true, 200, null))

    }


}