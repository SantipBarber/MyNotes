package extensions

import androidx.compose.runtime.MutableState

fun <T> MutableState<T>.update(newState: (T) -> T) = apply {
    value = newState(value)
}