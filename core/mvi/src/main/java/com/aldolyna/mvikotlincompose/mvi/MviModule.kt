package com.aldolyna.mvikotlincompose.mvi

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.logging.logger.DefaultLogFormatter
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MviModule {
    @Provides
    @Singleton
    fun storeFactory(): StoreFactory {
        return if (BuildConfig.DEBUG) {
            LoggingStoreFactory(
                delegate = DefaultStoreFactory(),
                logFormatter = DefaultLogFormatter(),
            )
        } else {
            DefaultStoreFactory()
        }
    }
}
