package com.aldolyna.mvikotlincompose.di

import com.aldolyna.mvikotlincompose.mvi.MviModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MviModule::class
    ]
)
interface ApplicationComponent
