package com.example.buttonex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Buttonコンポーネントを利用した処理を作成する
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
    // カウント数を格納
    val counter = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        // カウント数の表示
        Text(
            color = Color.Black,
            text = "count: ${counter.value}",
            modifier = Modifier.padding(20.dp),
            style = TextStyle(fontSize = 24.sp)
        )

        // カウントを加算するボタン
        Button(
            onClick = { counter.value++ }) {
            Text(
                text = "Count up", style = TextStyle(fontSize = 24.sp)
            )
        }
    }
}
