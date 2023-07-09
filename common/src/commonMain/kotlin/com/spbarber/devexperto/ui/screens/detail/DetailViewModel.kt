package com.spbarber.devexperto.ui.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.spbarber.devexperto.data.model.Note
import com.spbarber.devexperto.data.remote.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DetailViewModel(private val scope: CoroutineScope, private val id: Long) {

    var state by mutableStateOf(UiState())
        private set

    init {
        if (id != Note.NEW_NOTE_ID) {
            loadNote()
        }
    }

    private fun loadNote() {
        scope.launch {
            state = UiState(loading = true)
            state = UiState(note = NotesRepository.getById(id))
        }
    }

    fun save() {
        state = state.copy(loading = true)
        scope.launch {
            val note = state.note
            if (note.id == Note.NEW_NOTE_ID) {
                NotesRepository.save(note)
            } else {
                NotesRepository.update(note)
            }
        }
        state = state.copy(saved = true, loading = false)
    }

    fun update(note: Note) {
        state = state.copy(note = note)
    }

    fun delete() {
        scope.launch {
            NotesRepository.delete(state.note)
            state = state.copy(saved = true)
        }
    }

    data class UiState(
        val note: Note = Note(title = "", description = "", type = Note.Type.TEXT),
        val loading: Boolean = false,
        val saved: Boolean = false
    )
}
