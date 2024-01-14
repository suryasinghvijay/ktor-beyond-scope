package bts.chat.com.di.module

import bts.chat.com.auth.service.AuthService
import bts.chat.com.auth.service.impl.AuthServiceImpl
import bts.chat.com.db.datastore.impl.AuthDataStoreImpl
import org.koin.dsl.module


val serviceModule = module{
    single <AuthService> {
        AuthServiceImpl(get())
    }
}