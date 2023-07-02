package com.example.keyeventex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

// キーイベントを取得して、Canvasで表示する処理を作成
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayKeyEvent()
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@Preview(showBackground = true)
@Composable
fun DisplayKeyEvent() {
    val textMeasurer = rememberTextMeasurer()
    val requester = remember { FocusRequester() }
    val keyEventType = remember { mutableStateOf("Unknown") }
    val keyCode = remember { mutableStateOf("Unknown") }

    // Canvasに割り当てるModifier
    val canvasModifier = Modifier
        .fillMaxSize()
        .onKeyEvent {
            // キーイベントを格納
            keyEventType.value = "${it.type}"
            keyCode.value = "${it.nativeKeyEvent.keyCode}"
            true
        }
        .focusRequester(requester)
        .focusable()

    Canvas(
        modifier = canvasModifier,
        onDraw = {
            // 背景
            drawRect(color = Color.White)

            // テキストスタイル
            val textStyle = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                textDecoration = TextDecoration.None
            )

            // キーイベントの内容をテキストで表示
            val text = StringBuilder().apply {
                appendLine("KeyEventType= ${keyEventType.value}")
                appendLine("KeyCode= ${keyCode.value}")
            }.toString()

            drawText(
                textMeasurer = textMeasurer,
                text = text,
                topLeft = Offset(0f, 0f),
                style = textStyle
            )
        }
    )

    // 最初に割り当てるフォーカスを要求する
    LaunchedEffect(Unit) {
        requester.requestFocus()
    }
}
