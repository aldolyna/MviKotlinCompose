package com.aldolyna.mvikotlincompose.mvi

import androidx.lifecycle.ViewModel
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.states
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

abstract class MviViewModel<in Intent : Any, out State : Any, out Label : Any, S : Store<Intent, State, Label>>(
    protected val store: S
) : ViewModel() {

    open val states: Flow<State>
        get() = store.states

    val state: State
        get() = store.state

    val labels: Flow<Label>
        get() = store.labels

    fun accept(intent: Intent) {
        store.accept(intent)
    }

    override fun onCleared() {
        super.onCleared()
        store.dispose()
    }

    internal fun <T> collectState(
        scope: CoroutineScope,
        transform: (State) -> T,
        distinctUntilChanged: Boolean = true,
        consumer: suspend (T) -> Unit,
    ) {
        states
            .map(transform::invoke)
            .apply { if (distinctUntilChanged) distinctUntilChanged() }
            .onEach(consumer::invoke)
            .launchIn(scope)
    }

    internal fun collectLabels(
        scope: CoroutineScope,
        consumer: suspend (Label) -> Unit,
    ) {
        labels
            .onEach(consumer::invoke)
            .launchIn(scope)
    }
}
