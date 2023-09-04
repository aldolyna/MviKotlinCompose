package com.aldolyna.mvikotlincompose

import android.app.Application
import com.aldolyna.mvikotlincompose.di.DaggerAppComponent

class App : Application() {

    val appComponent = DaggerAppComponent.create()
}
