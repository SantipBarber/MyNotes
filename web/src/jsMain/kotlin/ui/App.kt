package ui

import androidx.compose.runtime.*
import com.spbarber.devexperto.ui.screens.Route
import com.spbarber.devexperto.ui.screens.detail.DetailViewModel
import com.spbarber.devexperto.ui.screens.home.HomeViewModel
import ui.screens.detail.Detail
import ui.screens.home.Home

@Composable
fun App() {
    var route: Route by remember { mutableStateOf(Route.Home) }
    val scope = rememberCoroutineScope()

    route.let {
        when (it) {
            is Route.Detail -> Detail(DetailViewModel(scope = scope, id = it.id), onClose = { route = Route.Home })
            Route.Home -> Home(vm = HomeViewModel(scope), onNoteClicked = { noteId -> route = Route.Detail(id = noteId) })
        }
    }
}