package com.spbarber.devexperto.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.spbarber.devexperto.ui.screens.detail.DetailScreen
import com.spbarber.devexperto.ui.screens.viewmodels.HomeViewModel

object HomeScreen: Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Home(vm = HomeViewModel(rememberCoroutineScope()), onNoteClicked = { navigator.push(DetailScreen(it)) })
    }
}

@Composable
expect fun Home(
    vm: HomeViewModel,
    onNoteClicked: (noteId: Long) -> Unit
)