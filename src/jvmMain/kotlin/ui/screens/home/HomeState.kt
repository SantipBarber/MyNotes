package ui.screens.home

import data.model.Filter
import data.model.Note
import data.remote.notesClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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


object HomeState {
    private val _state = MutableStateFlow(UiState())
     val state = _state.asStateFlow()

    //var state: UiState by MutableStateFlow(UiState())
    //    private set
    fun loadNotes(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            val notes = notesClient.request("http://0.0.0.0:8080/notes")
            println(notes.body() as String)
        }
    }


    fun onFilterClick(filter: Filter) {
        _state.value = UiState(filter = filter)
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