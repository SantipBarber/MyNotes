package com.spbarber.devexperto

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.spbarber.devexperto.ui.screens.home.HomeScreen

@Composable
fun App() {
    Navigator(HomeScreen)
}

