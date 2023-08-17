package com.spbarber.devexperto.ui.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.spbarber.devexperto.data.model.Note


@Composable
fun Detail(vm: DetailViewModel, onClose: () -> Unit) {

    val note = vm.state.note

    Scaffold(
        topBar = {
            TopBar(
                note = note,
                onClose = onClose,
                onSave = vm::save,
                onDelete = vm::delete
            )
        },
    ) { paddingValues ->
        if (vm.state.saved) {
            onClose()
        }
        if (vm.state.loading) {
            CircularProgressIndicator()
        } else {

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(32.dp)

            ) {
                OutlinedTextField(
                    value = note.title,
                    onValueChange = {  vm.update(note.copy(title = it)) },
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = { Text("Title") },
                    singleLine = true
                )
                TypeDropdown(
                    value = note.type,
                    onValueChange = { vm.update(note.copy(type = it)) },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = note.description,
                    onValueChange = {  vm.update(note.copy(description = it)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    label = { Text("Description") },
                    singleLine = false
                )
            }
        }

    }
}

@Composable
private fun TypeDropdown(value: Note.Type, onValueChange: (Note.Type) -> Unit, modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier, propagateMinConstraints = true) {
        OutlinedTextField(
            value = value.toString(),
            onValueChange = { },
            readOnly = true,
            label = { Text("Type") },
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Show note type")
                }
            }
        )
        /*DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            Note.Type.values().forEach {
                DropdownMenuItem(onClick = { onValueChange(it); expanded = false }) {
                    Text(it.name)
                }
            }
        }*/
    }
}

@Composable
private fun TopBar(note: Note, onClose: () -> Unit, onSave: () -> Unit, onDelete: () -> Unit) {
    TopAppBar(
        title = { Text(note.title) },
        navigationIcon = {
            IconButton(onClick = onClose) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "Close Detail")
            }
        },
        actions = {
            IconButton(onClick = onSave) {
                Icon(imageVector = Icons.Default.Save, contentDescription = "Save Note")
            }
            if (note.id != Note.NEW_NOTE_ID) {
                IconButton(onClick = onDelete) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Note")
                }
            }
        }
    )
}