package data.model

import data.model.Note.Type.AUDIO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class Note(
    val title: String,
    val description: String,
    val type: Type
) {
    enum class Type {
        TEXT,
        AUDIO
    }

    /**
     * Necesitamos declararlo para que podamos crear propiedades de tipo extensión de manera externa también
     */
    companion object
}

operator fun Note.plus(other: Note): Note = Note(title, "$description ${other.description}", type)

fun test(note1: Note, note2: Note) = note1 + note2

/**
 * Extension property
 * Esta es la forma en al que podemos crear propiedades de tipo extensión
 */
val Note.Companion.fakeNotes: Flow<List<Note>>  get() = flow {
    delay(2_000)
    val notes = (1..10).map {
        Note(
            title = "Title $it",
            description = "Description $it",
            if (it % 3 == 0) AUDIO else Note.Type.TEXT
        )
    }
    emit(notes)
}