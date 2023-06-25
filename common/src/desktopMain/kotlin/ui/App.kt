package ui

import androidx.compose.runtime.*
import ui.screens.detail.Detail
import ui.screens.detail.DetailViewModel
import ui.screens.home.Home
import ui.screens.home.HomeViewModel

sealed interface Route {
    object Home : Route
    data class Detail(val id: Long) : Route
}

@Composable
fun App() {
    var route: Route by remember { mutableStateOf(Route.Home) }
    val scope = rememberCoroutineScope()

    route.let {
        when (it) {
            is Route.Detail -> Detail(DetailViewModel(scope = scope, id = it.id), onClose = { route = Route.Home })
            Route.Home -> Home(vm = HomeViewModel(scope), onNoteClick = {noteId -> route = Route.Detail(id = noteId) })
        }
    }
}

