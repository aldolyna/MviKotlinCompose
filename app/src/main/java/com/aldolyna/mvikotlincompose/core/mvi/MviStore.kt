package com.aldolyna.mvikotlincompose.core.mvi

import com.aldolyna.mvikotlincompose.BuildConfig
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.logging.logger.DefaultLogFormatter
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory

object MviStore {
    val factory: StoreFactory by lazy {
        if (BuildConfig.DEBUG) {
            LoggingStoreFactory(
                delegate = DefaultStoreFactory(),
                logFormatter = DefaultLogFormatter(),
            )
        } else {
            DefaultStoreFactory()
        }
    }
}
