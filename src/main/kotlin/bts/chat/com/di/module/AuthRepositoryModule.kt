package bts.chat.com.di.module

import bts.chat.com.auth.repository.AuthRepository
import bts.chat.com.auth.repository.impl.AuthRepositoryImpl
import bts.chat.com.chat.repository.UserRepository
import bts.chat.com.chat.repository.impl.UserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> {
        AuthRepositoryImpl(get())
    }
    //TODO: rename user repository to chatRepository
    single<UserRepository> {
        UserRepositoryImpl(get())
    }
}