package com.spbarber.devexperto.ui.screens.detail

import androidx.compose.runtime.Composable
import com.spbarber.devexperto.ui.screens.viewmodels.DetailViewModel

@Composable
expect fun Detail(vm: DetailViewModel, onClose: () -> Unit)