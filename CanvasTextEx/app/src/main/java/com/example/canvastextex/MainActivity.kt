package com.example.canvastextex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasDrawText()
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@Preview(widthDp = 320, heightDp = 480)
@Composable
fun CanvasDrawText() {
    val textMeasurer = rememberTextMeasurer()

    Canvas(modifier = Modifier.fillMaxSize()) {
        // 背景
        drawRect(color = Color.White)

        // テキスト
        val textStyle = TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textDecoration = TextDecoration.None
        )

        val text = StringBuilder().apply {
            appendLine("Hello world!")
            appendLine("画面サイズ: width= ${size.width.toDp()}, height= ${size.height.toDp()}")
            appendLine("フォントサイズ: ${textStyle.fontSize}")
        }

        drawText(
            textMeasurer = textMeasurer,
            text = text.toString(),
            topLeft = Offset(0f, 0f),
            style = textStyle
        )
    }
}
