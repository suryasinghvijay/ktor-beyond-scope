package bts.chat.com.di.module

import io.ktor.server.application.*
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo


val appModule = module {
    single {
        KMongo.createClient().coroutine.getDatabase("bts_chat_db")
    }
}