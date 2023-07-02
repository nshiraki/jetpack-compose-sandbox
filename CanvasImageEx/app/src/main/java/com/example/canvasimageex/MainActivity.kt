package com.example.canvasimageex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize

// Canvasに画像を描画する処理を作成する
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val image = ImageBitmap.imageResource(id = R.drawable.bike_auto_race)
            CanvasDrawImage(image = image)
        }
    }
}

@Composable
fun CanvasDrawImage(image: ImageBitmap) {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        // 背景塗りつぶし
        drawRect(Color.White)

        // 画像を描画
        drawImage(image = image)

        // 画像を縮小して描画
        val width = image.width
        val height = image.height
        drawImage(
            image = image,
            dstOffset = IntOffset(0, height),
            dstSize = IntSize(width / 2, height / 2),
        )
    })
}

@Preview(showBackground = true)
@Composable
fun PreviewCanvasDrawImage() {
    CanvasDrawImage(ImageBitmap.imageResource(id = R.drawable.bike_auto_race))
}


