package com.spbarber.devexperto.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.spbarber.devexperto.data.model.Note

@Composable
fun Home(vm: HomeViewModel, onNoteClick: (noteId: Long) -> Unit) {

    MaterialTheme {
        Scaffold(
            topBar = {
                TopBar(onFilterClick = { vm.onFilterClick(it) })
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { onNoteClick(Note.NEW_NOTE_ID) }
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Note")
                }
            }
        ) { padding ->
            Box(
                modifier = Modifier.fillMaxSize().padding(padding),
                contentAlignment = Alignment.TopCenter
            ) {
                if (vm.state.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }

                vm.state.filteredNotes?.let { note -> NotesList(note) { onNoteClick(it.id) } }
            }
        }
    }
}
