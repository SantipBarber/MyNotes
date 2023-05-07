package ui.screens.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.*
import data.model.Filter
import data.model.Note

@Composable
fun TopBar(onFilterClick: (Filter) -> Unit) {
    TopAppBar(
        title = { Text("My Notes") },
        actions = {
            FilterAction(
                onFilterClick
            )
        }
    )
}

@Composable
private fun FilterAction(onFilterClick: (Filter) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    IconButton(
        onClick = { expanded = !expanded }
    ) {
        Icon(imageVector = Icons.Default.FilterList, contentDescription = "Filter list")
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onFilterClick(Filter.All)
                }
            ) {
                Text(text = "All")
            }
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onFilterClick(Filter.ByType(Note.Type.TEXT))
                }
            ) {
                Text(text = "Text")
            }
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onFilterClick(Filter.ByType(Note.Type.AUDIO))
                }
            ) {
                Text(text = "Audio")
            }
        }
    }
}