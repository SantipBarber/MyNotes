import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App(): Unit = with(AppState) {

    if (state.notes == null) LaunchedEffect(true) { loadNotes(this) }

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            /**
             * Puede hacerse con when, pero si lo hacemos con if lo visualizaríamos sobre el listado generado.
             */
            if (state.isLoading) {
                CircularProgressIndicator()
            }

            state.notes?.let { NotesList(it) }
        }
    }
}

class Database

fun main() {
    val db by lazy { Database() }
    application {
        Window(onCloseRequest = ::exitApplication, title = "MyNotes") {
            App()
        }
    }
}

