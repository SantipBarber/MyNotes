package ui.screens.home

import androidx.compose.runtime.Composable
import com.spbarber.devexperto.ui.screens.home.HomeViewModel
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun Home(
    vm: HomeViewModel,
    onNoteClicked: (noteId: Long) -> Unit
) {
    Div {
       TopBar(onFilterClick = { vm.onFilterClick(it) })

        Div {
            if (vm.state.isLoading) {
                Text("Cargando...")
            }

            vm.state.filteredNotes?.let { note ->
                NoteList(
                    notes = note,
                    onClick = { onNoteClicked(it.id) }
                )
            }
        }

        Div {
            Text("+")
        }
    }
}