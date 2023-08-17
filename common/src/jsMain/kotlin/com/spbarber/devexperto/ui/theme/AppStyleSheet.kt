package com.spbarber.devexperto.ui.theme

import org.jetbrains.compose.web.css.*
import org.jetbrains.skia.FontWeight

object AppStyleSheet : StyleSheet() {

    init {
        "*" style {
            fontFamily("Verdana", "sans-serif")
            margin(0.px)
            padding(0.px)
        }

        "body" style {
            marginTop(64.px)
        }

    }

    val fab by style {
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
        position(Position.Fixed)
        bottom(16.px)
        right(16.px)
        width(64.px)
        height(64.px)
        borderRadius(50.percent)
        backgroundColor(Color("#6200EE"))
        color(Color.white)
        fontSize(24.px)
        lineHeight(1.em)
        cursor("pointer")
        property("box-shadow", "0 5px 5px 0 rgba(0,0,0,0.4)")
        self + hover style { backgroundColor(Color("#6200eccc")) }
    }

    val topBar by style {
        position(Position.Absolute)
        top(0.px)
        left(0.px)
        right(0.px)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.SpaceAround)
        backgroundColor(Color("#6200EE"))
        gap(16.px)
        padding(16.px)
    }

    val topBarTitle by style {
        color(Color.white)
        margin(0.px)
        fontSize(25.px)
        fontWeight(FontWeight.NORMAL)
        property("margin-right", "auto")
    }

    val topBarIcon by style {
        color(Color.white)
        cursor("pointer")
        fontSize(24.px)
        borderRadius(50.percent)
        padding(12.px)
        self + hover style { backgroundColor(Color("#ffffff4d")) }
    }

    val filterAction by style {
        cursor("pointer")
    }

    val filterActionExpanded by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.SpaceBetween)
        borderRadius(4.px)
        position(Position.Absolute)
        backgroundColor(Color.white)
        top(16.px)
        right(16.px)
        property("box-shadow", "0 0 4px rgba(0,0,0,0.25)")
        property("z-index", 1)
    }

    val filterActionExpandedItem by style {
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
        padding(16.px)
        minWidth(150.px)
        cursor("pointer")
    }

    val noteCardTitle by style {
        style {
            flex(1)
            lineHeight(1.5.em)
            margin(0.px)
            fontSize(20.px)
            fontWeight(FontWeight.NORMAL)
        }
    }

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

    val detailInput by style {
        padding(16.px)
        borderRadius(4.px)
        border(1.px, LineStyle.Solid, Color("#ccc"))
    }
}