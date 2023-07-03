package com.example.textex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

// Textコンポーネントを利用して文字列を表示する処理を行う
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreen()
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun AppScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, // 横方向
        verticalArrangement = Arrangement.Center // 縦方向
    ) {
        // 引数で文字列を指定
        Text(text = "Hello")

        // stringリソースの文字列を指定
        Text(stringResource(id = R.string.hello))

        // 文字色と背景色を指定
        Text(
            modifier = Modifier.background(Color.Black),
            text = "Text color",
            color = Color.White
        )
        Text(
            modifier = Modifier.background(Color.Black),
            text = "Text color",
            color = Color.Yellow
        )
        Text(
            modifier = Modifier.background(Color.Black),
            text = "Text color",
            color = Color.Cyan
        )

        // フォントサイズを指定
        Text(text = "Text fontSize", fontSize = 16.sp)
        Text(text = "Text fontSize", fontSize = 24f.sp)
        Text(text = "Text fontSize", fontSize = 32f.sp)

        // 複数行文字列
        // 文字列の最大行数を指定
        // 何も指定しない場合は、文字列全体が複数行にわたって表示される
        val text = "あのイーハトーヴォのすきとおった風、夏でも底に冷たさをもつ青いそら、うつくしい森で飾られたモリーオ市、郊外のぎらぎらひかる草の波。"
        Text(text = text, color = Color.Red)
        Text(text = text, color = Color.Blue, maxLines = 2)
        Text(text = text, color = Color.Black, maxLines = 1)
    }
}

