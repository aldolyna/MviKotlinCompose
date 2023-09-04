package com.aldolyna.mvikotlincompose.di

import com.aldolyna.mvikotlincompose.core.di.scope.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent
