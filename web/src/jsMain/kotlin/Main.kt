import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.spbarber.devexperto.data.model.Note
import com.spbarber.devexperto.ui.screens.home.HomeViewModel
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import ui.theme.AppStyleSheet

fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStyleSheet)
        val scope = rememberCoroutineScope()
        val homeViewModel = remember { HomeViewModel(scope) }

        Div({ style { padding(25.px) } }) {
            H1 { Text("DevExperto") }
            NoteList(homeViewModel.state.filteredNotes ?: emptyList()) { note ->
                console.log("Note clicked: $note")

            }
        }
    }
}

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
                    style {
                        flex(1)
                    }
                }
            ) { Text(note.title) }
            if (note.type == Note.Type.AUDIO) {
                Span { Text("🎤") }
            }
        }
        Div {
            Text(note.description)
        }
    }
}