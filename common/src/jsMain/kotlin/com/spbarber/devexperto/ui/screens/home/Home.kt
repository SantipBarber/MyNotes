package com.spbarber.devexperto.ui.screens.home

import androidx.compose.runtime.Composable
import com.spbarber.devexperto.data.model.Note
import com.spbarber.devexperto.ui.screens.viewmodels.HomeViewModel
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import com.spbarber.devexperto.ui.theme.AppStyleSheet

@Composable
actual fun Home(
    vm: HomeViewModel,
    onNoteClicked: (noteId: Long) -> Unit
) {
    Div(
        attrs = {
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                width(100.percent)
                height(100.percent)
            }
        }
    ) {
        TopBar(onFilterClick = { vm.onFilterClick(it) })

        if (vm.state.isLoading) {
            Text("Cargando...")
        }

        vm.state.filteredNotes?.let { note ->
            NoteList(
                notes = note,
                onClick = { onNoteClicked(it.id) }
            )
        }

        Div(
            attrs = {
                classes(AppStyleSheet.fab)
                onClick { onNoteClicked(Note.NEW_NOTE_ID) }
            }
        ) {
            Text("+")
        }
    }
}