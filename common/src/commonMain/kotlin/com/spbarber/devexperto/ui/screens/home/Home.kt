package com.spbarber.devexperto.ui.screens.home

import androidx.compose.runtime.Composable
import com.spbarber.devexperto.ui.screens.viewmodels.HomeViewModel

@Composable
expect fun Home(
    vm: HomeViewModel,
    onNoteClicked: (noteId: Long) -> Unit
)