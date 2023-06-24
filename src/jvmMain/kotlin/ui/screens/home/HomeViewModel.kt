package ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import data.model.Filter
import data.model.Note
import data.remote.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.reflect.KProperty

operator fun <T> StateFlow<T>.getValue(
    owner: Any?,
    property: KProperty<*>
): T = this.value

operator fun <T> MutableStateFlow<T>.setValue(
    owner: Any?,
    property: KProperty<*>,
    newValue: T
) {
    this.value = newValue
}


class HomeViewModel(private val scope: CoroutineScope) {

    var state by mutableStateOf(UiState())
        private set

    init {
        loadNotes()
    }
    private fun loadNotes() {
        scope.launch {
            state= UiState(isLoading = true)
            val notes = NotesRepository.getAll()
            state= UiState(notes = notes)
        }
    }


    fun onFilterClick(filter: Filter) {
        state= UiState(filter = filter)
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