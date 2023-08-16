package ui.screens.home

import androidx.compose.runtime.*
import com.spbarber.devexperto.data.model.Filter
import com.spbarber.devexperto.data.model.Note
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text
import ui.common.Icon
import ui.theme.AppStyleSheet

@Composable
fun TopBar(onFilterClick: (Filter) -> Unit) {

    Div(
        attrs = {
            classes(AppStyleSheet.topBar)
        }
    ) {
        H1(attrs = {
            classes(AppStyleSheet.topBarTitle)
        }) { Text("Mis notas") }
        FilterAction(onFilterClick)
    }
}

@Composable
private fun FilterAction(onFilterClick: (Filter) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Div(attrs = { classes(AppStyleSheet.filterAction) }) {
        Div(
            attrs = {
                style { color(Color.white) }
                onClick { expanded = !expanded }
            }
        ) {
            Icon(iconName = "search", attrs = { classes(AppStyleSheet.topBarIcon) })
        }

        if (expanded) {
            Div(
                attrs = {
                    classes(AppStyleSheet.filterActionExpanded)
                }
            ) {
                listOf(
                    Filter.All to "All",
                    Filter.ByType(Note.Type.TEXT) to "Text",
                    Filter.ByType(Note.Type.AUDIO) to "Audio"
                ).forEach { (filter, text) ->
                    Div(attrs = {
                        classes(AppStyleSheet.filterActionExpandedItem)
                        onClick {
                            expanded = false
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
