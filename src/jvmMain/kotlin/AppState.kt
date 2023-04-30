import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import model.Note
import model.getNotes

object AppState {
    var state: UiState by mutableStateOf(UiState())
    fun loadNotes(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            state = UiState(isLoading = true)
            val notes = async { getNotes() }
            state = UiState(isLoading = false, notes = notes.await())
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val notes: List<Note>? = null
    )
}