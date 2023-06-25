import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.spbarber.devexperto.getAppTitle
import ui.App


class Database

fun main() {
    val db by lazy { Database() }
    application {
        Window(onCloseRequest = ::exitApplication, title = getAppTitle()) {
            App()
        }
    }
}

