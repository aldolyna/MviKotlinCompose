package com.aldolyna.mvikotlincompose.core.mvi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
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
    val currentConsumer by rememberUpdatedState(consumer)
    LaunchedEffect(Unit) {
        viewModel.collectLabels(this) {
            currentConsumer(it)
        }
    }
}

@Composable
fun <Label : Any> CollectLabelsOnLifecycleLaunchedEffect(
    viewModel: MviViewModel<*, *, Label, *>,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    consumer: suspend CoroutineScope.(Label) -> Unit
) {
    val currentConsumer by rememberUpdatedState(consumer)
    LaunchedEffect(Unit) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(state) {
            viewModel.collectLabels(this) {
                currentConsumer(it)
            }
        }
    }
}
