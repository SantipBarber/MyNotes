package ui.theme

import org.jetbrains.compose.web.css.*

object AppStyleSheet: StyleSheet() {

    val noteCardContent by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.SpaceBetween)
    }

    val noteCard by style {
        display(DisplayStyle.Flex)
        flexDirection(flexDirection = FlexDirection.Column)
        width(80.percent)
        maxWidth(600.px)
        padding(12.px)
        border(width = 1.px, style = LineStyle.Solid, color = Color.aquamarine)
        borderRadius(4.px)
        cursor("pointer")
    }

    val noteList by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        width(100.percent)
        height(100.percent)
        gap(16.px)
        alignItems(AlignItems.Center)
    }


}