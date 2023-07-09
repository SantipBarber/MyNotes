package ui.screens.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.*
import com.spbarber.devexperto.getAppTitle
import com.spbarber.devexperto.data.model.Filter
import com.spbarber.devexperto.data.model.Note

@Composable
fun TopBar(onFilterClick: (Filter) -> Unit) {
    TopAppBar(
        title = { Text(getAppTitle()) },
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

/*    @Composable
    infix fun Filter.ToMenuItem(label: String) =
        DropdownMenuItem(
            onClick = {
                expanded = false
                onFilterClick(this)
            }
        ) {
            Text(text = label)
        }*/

    IconButton(
        onClick = { expanded = !expanded }
    ) {
        Icon(imageVector = Icons.Default.FilterList, contentDescription = "Filter list")
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {


           /* Filter.All ToMenuItem "All"
            Filter.ByType(Note.Type.TEXT) ToMenuItem "Text"
            Filter.ByType(Note.Type.AUDIO) ToMenuItem "Audio"*/

            listOf(
                 Filter.All to "All",
                 Filter.ByType(Note.Type.TEXT) to "Text",
                 Filter.ByType(Note.Type.AUDIO) to "Audio"
             ).forEach { (filter, label) ->
                 DropdownMenuItem(
                     onClick = {
                         expanded = false
                         onFilterClick(filter)
                     }
                 ) {
                     Text(text = label)
                 }
             }
        }
    }
}
