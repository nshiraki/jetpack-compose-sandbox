package com.example.toucheventex

import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// タッチイベントを取得し、Canvasで表示する処理を行う
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayTouchEvent()
        }
    }

}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalTextApi::class)
@Preview(showBackground = true)
@Composable
fun DisplayTouchEvent() {
    val action = remember { mutableStateOf("Unknown") }
    val touchX = remember { mutableStateOf("Unknown") }
    val touchY = remember { mutableStateOf("Unknown") }

    // タッチイベントを処理するModifierを作成
    val canvasModifier = Modifier
        .fillMaxSize()
        .pointerInteropFilter {
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    action.value = "ACTION_DOWN"
                    touchX.value = it.x.toString()
                    touchY.value = it.y.toString()
                }

                MotionEvent.ACTION_UP -> {
                    action.value = "ACTION_UP"
                    touchX.value = it.x.toString()
                    touchY.value = it.y.toString()
                }

                MotionEvent.ACTION_MOVE -> {
                    action.value = "ACTION_MOVE"
                    touchX.value = it.x.toString()
                    touchY.value = it.y.toString()
                }

                MotionEvent.ACTION_CANCEL -> {
                    action.value = "ACTION_CANCEL"
                    touchX.value = it.x.toString()
                    touchY.value = it.y.toString()
                }

                else -> false
            }
            true
        }

    val textMeasurer = rememberTextMeasurer()
    Canvas(
        modifier = canvasModifier,
        onDraw = {
            // テキストスタイル
            val textStyle = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                textDecoration = TextDecoration.None
            )

            // タッチイベントと座標を表示
            val text = StringBuilder().apply {
                appendLine("action= ${action.value}")
                appendLine("touchX= ${touchX.value}")
                appendLine("touchY= ${touchY.value}")
            }.toString()

            drawText(
                textMeasurer = textMeasurer,
                text = text,
                topLeft = Offset(0f, 0f),
                style = textStyle
            )
        }
    )
}
