package ui.screens.home

import androidx.compose.runtime.*
import com.spbarber.devexperto.data.model.Filter
import com.spbarber.devexperto.data.model.Note
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

@Composable
fun TopBar(onFilterClick: (Filter) -> Unit) {
    Div {
        H1 { Text("Mis notas") }
        FilterAction(onFilterClick)
    }
}

@Composable
private fun FilterAction(onFilterClick: (Filter) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Div {
        Div(
            attrs = { onClick { expanded = !expanded } }
        ) {
            Text("🔎")
        }

        if (expanded) {
            Div {
                listOf(
                    Filter.All to "All",
                    Filter.ByType(Note.Type.TEXT) to "Text",
                    Filter.ByType(Note.Type.AUDIO) to "Audio"
                ).forEach { (filter, text) ->
                    Div(attrs = {
                        onClick {
                            expanded = false
                            console.log("onFilterClick ${filter.toString()}. $text")
                            onFilterClick(filter)
                        }
                    }) {
                        Text(text)
                    }
                }
            }
        }
    }
}
