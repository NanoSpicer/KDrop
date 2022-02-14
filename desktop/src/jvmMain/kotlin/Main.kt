import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import screens.DesktopApp

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Ligma", state = WindowState(width = 1080.dp, height = 720.dp, position = WindowPosition(
        Alignment.Center
    ))) {
        MaterialTheme {
            DesktopApp()
        }
    }
}