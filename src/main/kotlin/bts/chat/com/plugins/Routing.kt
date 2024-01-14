package bts.chat.com.plugins

import bts.chat.com.auth.signupEndPoint
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.get

fun Application.configureRouting() {
    routing {
        signupEndPoint(get())
    }
}
