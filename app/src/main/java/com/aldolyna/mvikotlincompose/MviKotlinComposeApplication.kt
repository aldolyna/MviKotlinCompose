package com.aldolyna.mvikotlincompose

import android.app.Application
import com.aldolyna.mvikotlincompose.di.DaggerAppComponent

class MviKotlinComposeApplication : Application() {

    val appComponent = DaggerAppComponent.create()
}
