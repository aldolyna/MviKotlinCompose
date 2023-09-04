package com.aldolyna.mvikotlincompose.core.mvi

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineBootstrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class MviBootstrapper<Action : Any> : CoroutineBootstrapper<Action>(
    mainContext = Dispatchers.Main.immediate + SupervisorJob()
)
