package com.spbarber.devexperto.data.model

import com.spbarber.devexperto.data.model.Note.Type.AUDIO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val id: Long = NEW_NOTE_ID,
    val title: String,
    val description: String,
    val type: Type
) {
    enum class Type {
        TEXT,
        AUDIO
    }
    companion object {
        const val NEW_NOTE_ID = -1L
    }
}

operator fun Note.plus(other: Note): Note = Note(1000L ,title, "$description ${other.description}", type)

fun test(note1: Note, note2: Note) = note1 + note2

/**
 * Extension property
 * Esta es la forma en al que podemos crear propiedades de tipo extensión
 */
val Note.Companion.fakeNotes: Flow<List<Note>>  get() = flow {
    delay(2_000)
    val notes = (1..10).map {
        Note(
            id = it.toLong(),
            title = "Title $it",
            description = "Description $it",
            if (it % 3 == 0) AUDIO else Note.Type.TEXT
        )
    }
    emit(notes)
}