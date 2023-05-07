package ui.screens.home

import data.model.Filter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import data.model.Note
import data.model.getNotes
import kotlinx.coroutines.flow.update

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


    fun onFilterClick(filter: Filter) {
        _state.update { it.copy(filter = filter) }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val notes: List<Note>? = null,
        val filter: Filter = Filter.All
    ) {
        val filteredNotes: List<Note>?
            get() = when (filter) {
                Filter.All -> notes
                is Filter.ByType -> {
                    notes?.filter { it.type == filter.type }
                }
            }
    }
}