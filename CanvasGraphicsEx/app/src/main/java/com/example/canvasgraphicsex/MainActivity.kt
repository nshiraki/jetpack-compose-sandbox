package com.example.canvasgraphicsex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasDrawGraphics()
        }
    }
}

@Preview(showBackground = true, widthDp = 300, heightDp = 300)
@Composable
fun CanvasDrawGraphics() {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {

        val strokeWidth = 1.dp.toPx()

        // ライン
        drawLine(
            Color.Green,
            start = Offset(25.dp.toPx(), 5.dp.toPx()),
            end = Offset(25.dp.toPx(), (5 + 40).dp.toPx()),
            strokeWidth = strokeWidth
        )

        // パス
        drawPath(
            path = Path().apply {
                moveTo(55.dp.toPx(), 5.dp.toPx())
                lineTo((55 + 30).dp.toPx(), (5 + 5).dp.toPx())
                lineTo((55 + 10).dp.toPx(), (5 + 20).dp.toPx())
                lineTo((55 + 40).dp.toPx(), (5 + 25).dp.toPx())
                lineTo((55 + 0).dp.toPx(), (5 + 40).dp.toPx())
            },
            color = Color.Red,
            style = Stroke(width = strokeWidth)
        )

        // 四角形
        drawRect(
            color = Color.Gray,
            topLeft = Offset(x = 5.dp.toPx(), y = 50.dp.toPx()),
            size = Size(width = 40.dp.toPx(), height = 40.dp.toPx()),
            style = Stroke(width = strokeWidth)
        )

        // 四角形塗りつぶし
        drawRect(
            color = Color.Gray,
            topLeft = Offset(x = 55.dp.toPx(), y = 50.dp.toPx()),
            size = Size(width = 40.dp.toPx(), height = 40.dp.toPx()),
            style = Fill
        )

        // 角丸矩形
        drawRoundRect(
            color = Color.Gray,
            topLeft = Offset(x = 5.dp.toPx(), y = 100.dp.toPx()),
            size = Size(width = 40.dp.toPx(), height = 40.dp.toPx()),
            cornerRadius = CornerRadius(x = 10.dp.toPx(), y = 10.dp.toPx()),
            style = Stroke(width = strokeWidth)
        )

        // 角丸矩形塗りつぶし
        drawRoundRect(
            color = Color.Gray,
            topLeft = Offset(x = 55.dp.toPx(), y = 100.dp.toPx()),
            size = Size(width = 40.dp.toPx(), height = 40.dp.toPx()),
            cornerRadius = CornerRadius(x = 10.dp.toPx(), y = 10.dp.toPx()),
            style = Fill
        )

        // 円
        drawCircle(
            color = Color.Gray,
            center = Offset(x = 25.dp.toPx(), y = 170.dp.toPx()),
            radius = 20.dp.toPx(),
            style = Stroke(width = strokeWidth)
        )

        // 円塗りつぶし
        drawCircle(
            color = Color.Gray,
            center = Offset(x = 75.dp.toPx(), y = 170.dp.toPx()),
            radius = 20.dp.toPx(),
            style = Fill
        )
    })
}
