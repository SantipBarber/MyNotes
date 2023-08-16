package ui.screens.detail

import androidx.compose.runtime.Composable
import com.spbarber.devexperto.ui.screens.detail.DetailViewModel
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun Detail(
    vm: DetailViewModel,
    onClose: () -> Unit
) {
    Div {
        Text(vm.state.note.title)
    }
}