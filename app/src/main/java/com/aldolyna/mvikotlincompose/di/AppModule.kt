package com.aldolyna.mvikotlincompose.di

import com.aldolyna.mvikotlincompose.core.di.scope.ApplicationScope
import com.aldolyna.mvikotlincompose.core.mvi.MviStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    @ApplicationScope
    fun provideStoreFactory(): StoreFactory = MviStore.factory
}
