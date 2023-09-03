package com.aldolyna.mvikotlincompose.mvi

import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class MviExecutor<in Intent : Any, in Action : Any, in State : Any, Message : Any, Label : Any> :
    CoroutineExecutor<Intent, Action, State, Message, Label>(
        mainContext = Dispatchers.Main.immediate + SupervisorJob()
    )
