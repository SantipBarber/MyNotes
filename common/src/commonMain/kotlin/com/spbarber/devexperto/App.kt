package com.spbarber.devexperto

import androidx.compose.runtime.*
import com.spbarber.devexperto.ui.screens.Route
import com.spbarber.devexperto.ui.screens.detail.Detail
import com.spbarber.devexperto.ui.screens.detail.DetailViewModel
import com.spbarber.devexperto.ui.screens.home.Home
import com.spbarber.devexperto.ui.screens.home.HomeViewModel

@Composable
fun App() {
    var route: Route by remember { mutableStateOf(Route.Home) }
    val scope = rememberCoroutineScope()

    route.let {
        when (it) {
            is Route.Detail -> Detail(DetailViewModel(scope = scope, id = it.id), onClose = { route = Route.Home })
            Route.Home -> Home(
                vm = HomeViewModel(scope),
                onNoteClick = { noteId -> route = Route.Detail(id = noteId) })
        }
    }
}

