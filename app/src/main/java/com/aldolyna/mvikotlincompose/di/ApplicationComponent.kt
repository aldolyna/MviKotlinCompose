package com.aldolyna.mvikotlincompose.di

import com.aldolyna.mvikotlincompose.core.di.scope.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        ApplicationModule::class
    ]
)
interface ApplicationComponent
