package bts.chat.com.di.module

import bts.chat.com.auth.repository.AuthRepository
import bts.chat.com.auth.repository.impl.AuthRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> {
        AuthRepositoryImpl(get())
    }
}