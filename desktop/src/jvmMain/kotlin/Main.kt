import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import me.nanospicer.common.KDropTheme
import screens.DesktopApp

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Ligma", state = WindowState(width = 1080.dp, height = 720.dp, position = WindowPosition(
        Alignment.Center
    ))) {
        KDropTheme {
            DesktopApp()
        }
    }
}