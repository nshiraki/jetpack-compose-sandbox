package com.example.imageex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Imageコンポーネントを利用し画像を表示する処理を行う
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreen()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AppScreen() {
    val imageModifier = Modifier
        .size(150.dp)
        .border(BorderStroke(1.dp, Color.Black))
        .background(Color.Cyan)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // ContentScaleなし
        // 画像の拡大縮小なし
        Image(
            painter = painterResource(R.drawable.png_img),
            contentDescription = "A animal image"
        )

        Spacer(modifier = Modifier.height(8.dp))

        // ContentScale.Fit
        // 画像の縦横比を維持したまま、画像全体が表示エリアに収まるように拡大・縮小して画像を表示
        Image(
            painter = painterResource(R.drawable.png_img),
            contentDescription = "A sample Image",
            modifier = imageModifier,
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(8.dp))

        // ContentScale.Crop
        // 画像の縦横比を維持したまま、表示エリア全体を埋めるように画像を表示
        Image(
            painter = painterResource(R.drawable.png_img),
            contentDescription = "A png image",
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        // ContentScale.None
        // 画像の拡大縮小なし
        Image(
            painter = painterResource(R.drawable.png_img),
            contentDescription = "A png image",
            modifier = imageModifier,
            contentScale = ContentScale.None
        )

        Spacer(modifier = Modifier.height(8.dp))

        // ContentScale.FillBounds
        // 画像の高さと幅を表示エリアの高さと幅に合わせて拡大・縮小して画像を表示。
        // 画像の縦横比は維持されない
        Image(
            painter = painterResource(R.drawable.png_img),
            contentDescription = "A png image",
            modifier = imageModifier,
            contentScale = ContentScale.FillBounds
        )
    }
}
