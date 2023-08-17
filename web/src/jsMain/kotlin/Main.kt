import com.spbarber.devexperto.App
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.renderComposable
import com.spbarber.devexperto.ui.theme.AppStyleSheet

fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStyleSheet)

        Div({ style { padding(25.px) } }) {
            App()
        }
    }
}