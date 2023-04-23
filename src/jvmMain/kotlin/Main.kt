import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlin.concurrent.thread

@Composable
@Preview
fun App(appState: AppState) {
    val notes = appState.state.value.notes
    if (appState.state.value.notes == null) {
        LaunchedEffect(true) {
            appState.loadNotes()
        }
    }
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            /**
             * Puede hacerse con when, pero si lo hacemos con if lo visualizaríamos sobre el listado generado.
             */
            if (appState.state.value.isLoading) {
                CircularProgressIndicator()
            }
            if (notes != null) {
                NotesList(notes)
            }
        }
    }
}

@Composable
private fun NotesList(notes: List<Note>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(notes) { note ->
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row {
                        Text(
                            text = note.title,
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier
                                .weight(1f)
                        )
                        if (note.type == Note.Type.AUDIO) {
                            Icon(imageVector = Icons.Default.Mic, contentDescription = null)
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(note.description)
                }
            }
        }
    }
}

fun main() {
    val state = AppState()
    application {
        Window(onCloseRequest = ::exitApplication, title = "MyNotes") {
            App(state)
        }
    }
}

class AppState {
    val state = mutableStateOf(UiState())
    fun loadNotes() {
        thread {
            state.update { it.copy(isLoading = true) }
            getNotes { notes -> state.update { UiState(notes = notes, isLoading = false) } }

        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val notes: List<Note>? = null
    )
}

fun <T> MutableState<T>.update(newState: (T) -> T) = apply {
    value = newState(value)
}