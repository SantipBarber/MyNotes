package ui.screens.home

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import data.model.Note
import data.model.getNotes

object HomeState {
    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()
    fun loadNotes(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            _state.value = UiState(isLoading = true)


            getNotes().collect {
                _state.value = UiState(isLoading = false, notes = it)
            }
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val notes: List<Note>? = null
    )
}