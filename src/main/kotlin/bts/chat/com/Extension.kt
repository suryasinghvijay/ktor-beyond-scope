package bts.chat.com

import bts.chat.com.auth.exception.UserAlreadyExistsException
import bts.chat.com.base.BtsResponse
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*

suspend fun PipelineContext<Unit, ApplicationCall>.failedResponse(
    exception: Exception
) {
    call.respond(
        BtsResponse<Unit>(
            null,
            true,
            200,
            hashMapOf("error" to exception.message.orEmpty())
        )
    )
}