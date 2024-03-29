package com.spbarber.devexperto.ui.screens.home

import androidx.compose.runtime.Composable
import com.spbarber.devexperto.data.model.Note
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import com.spbarber.devexperto.ui.common.Icon
import com.spbarber.devexperto.ui.theme.AppStyleSheet

@Composable
fun NoteList(notes: List<Note>, onClick: (Note) -> Unit) {
    Div(
        attrs = {
            classes(AppStyleSheet.noteList)
        }
    ) {
        notes.forEach { note ->
            NoteCard(note, onClick)
        }
    }
}

@Composable
fun NoteCard(note: Note, onClick: (Note) -> Unit) {
    Div(attrs = {
        onClick { onClick(note) }
        classes(AppStyleSheet.noteCard)
    }
    ) {
        Div(
            attrs = {
                classes(AppStyleSheet.noteCardContent)
            }
        ){
            H3(
                attrs = {
                    classes(AppStyleSheet.noteCardTitle)
                }
            ) { Text(note.title) }
            if (note.type == Note.Type.AUDIO) {
                Span {
                    Icon(
                        iconName = "mic"
                    )
                }
            }
        }
        Div {
            Text(note.description)
        }
    }
}