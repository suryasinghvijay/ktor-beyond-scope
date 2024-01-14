package bts.chat.com.plugins

import bts.chat.com.di.module.appModule
import bts.chat.com.di.module.dataStoreModule
import bts.chat.com.di.module.repositoryModule
import bts.chat.com.di.module.serviceModule
import io.ktor.server.application.*
import org.koin.core.context.startKoin

fun Application.configureKoin(){
    startKoin {
        modules(appModule, repositoryModule, dataStoreModule, serviceModule)
    }
}