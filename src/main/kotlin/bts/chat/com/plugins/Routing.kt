package bts.chat.com.plugins

import bts.chat.com.auth.authEndPoint
import bts.chat.com.chat.chatEndPoint
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.get

fun Application.configureRouting() {
    routing {
        authEndPoint(get())
        chatEndPoint(get())
    }
}
