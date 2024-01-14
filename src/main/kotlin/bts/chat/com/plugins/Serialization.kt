package bts.chat.com.plugins

import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.serialization.kotlinx.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}
