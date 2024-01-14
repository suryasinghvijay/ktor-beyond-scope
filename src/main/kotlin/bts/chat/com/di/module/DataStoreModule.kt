package bts.chat.com.di.module

import bts.chat.com.db.datastore.AuthDataStore
import bts.chat.com.db.datastore.impl.AuthDataStoreImpl
import org.koin.dsl.module

val dataStoreModule = module {
    single<AuthDataStore> {
        AuthDataStoreImpl(get())
    }
}