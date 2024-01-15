package bts.chat.com.di.module

import bts.chat.com.db.datastore.AuthDataStore
import bts.chat.com.db.datastore.UserDataStore
import bts.chat.com.db.datastore.impl.AuthDataStoreImpl
import bts.chat.com.db.datastore.impl.UserDataStoreImpl
import org.koin.dsl.module

val dataStoreModule = module {
    single<AuthDataStore> {
        AuthDataStoreImpl(get())
    }
    //TODO: rename user DataStore to chat DataStore
    single<UserDataStore> {
        UserDataStoreImpl(get())
    }
}