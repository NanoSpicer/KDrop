package screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import me.nanospicer.common.getPlatformName

import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import me.nanospicer.common.components.TextBox

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun DesktopApp() {
    var text by remember { mutableStateOf("Hello, World!") }
    var isOpen by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize()
            .background(color = Color(180, 180, 180))
            .padding(10.dp)
    ) {
        val stateVertical = rememberScrollState(0)
        val stateHorizontal = rememberScrollState(0)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(stateVertical)
                .padding(end = 12.dp, bottom = 12.dp)
                .horizontalScroll(stateHorizontal)
        ) {
            Column {
                Button(
                    onClick = {
                        isOpen = !isOpen
                    }) {
                    Icon(Icons.Rounded.Menu, contentDescription = "Localized description")
                }
                if (isOpen) {
                    TooltipArea(
                        tooltip = {
                            // composable tooltip content
                            Surface(
                                modifier = Modifier.shadow(4.dp),
                                color = Color(255, 255, 210),
                                shape = RoundedCornerShape(4.dp)
                            ) {
                                TextBox(
                                    text = "Tooltip for button",
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                        },
                        delayMillis = 600, // in milliseconds
                        tooltipPlacement = TooltipPlacement.CursorPoint(
                            alignment = Alignment.BottomEnd,
                            offset = DpOffset(40.dp, 12.dp) // tooltip offset
                        )
                    ) {
                        Button(onClick = {
                            text = "Hello, ${getPlatformName()}"
                        }) {
                            Text(text)
                        }
                    }
                }


            }
        }
        VerticalScrollbar(
            modifier = Modifier.align(Alignment.CenterEnd)
                .fillMaxHeight(),
            adapter = rememberScrollbarAdapter(stateVertical)
        )
        HorizontalScrollbar(
            modifier = Modifier.align(Alignment.BottomStart)
                .fillMaxWidth()
                .padding(end = 12.dp),
            adapter = rememberScrollbarAdapter(stateHorizontal)
        )
    }
}
