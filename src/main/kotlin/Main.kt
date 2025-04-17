import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.gameUI
import ui.hostUI

fun main() = application {
    Window(
        title = "Host",
        onCloseRequest = ::exitApplication) {
        hostUI()
    }
    Window(
        title = "Game",
        onCloseRequest = ::exitApplication) {
        gameUI()
    }
}
