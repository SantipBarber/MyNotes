package com.spbarber.devexperto.ui.screens.detail

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.spbarber.devexperto.ui.screens.viewmodels.DetailViewModel


data class DetailScreen(val id: Long) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Detail(vm = rememberScreenModel { DetailViewModel(id = id) }, onClose = { navigator.pop() })
    }
}
@Composable
expect fun Detail(vm: DetailViewModel, onClose: () -> Unit)