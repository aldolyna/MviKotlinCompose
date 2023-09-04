package com.aldolyna.mvikotlincompose.mvi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope

@Composable
fun <S : Any> MviViewModel<*, S, *, *>.composableState(): S =
    states.collectAsState(state).value

@Composable
fun <Label : Any> CollectLabelsLaunchedEffect(
    viewModel: MviViewModel<*, *, Label, *>,
    consumer: suspend CoroutineScope.(Label) -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.collectLabels(this) {
            consumer(it)
        }
    }
}

@Composable
fun <Label : Any> CollectLabelsOnLifecycleLaunchedEffect(
    viewModel: MviViewModel<*, *, Label, *>,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    consumer: suspend CoroutineScope.(Label) -> Unit
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    LaunchedEffect(Unit) {
        lifecycle.repeatOnLifecycle(state) {
            viewModel.collectLabels(this) {
                consumer(it)
            }
        }
    }
}
