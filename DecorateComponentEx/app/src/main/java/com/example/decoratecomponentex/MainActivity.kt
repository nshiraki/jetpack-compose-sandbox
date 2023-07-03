package com.example.decoratecomponentex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Modifierを利用してコンポーネントを装飾する処理を行う
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // 背景に色を付ける
        Text(
            text = "Hello",
            modifier = Modifier.background(color = Color.LightGray)
        )

        // 余白
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
        )

        // パディングを追加する
        Text(
            text = "Hello",
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(20.dp)
        )

        // 余白
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
        )

        // 背景の形を角丸にする
        Text(
            text = "Hello",
            modifier = Modifier
                .background(color = Color.LightGray, RoundedCornerShape(20.dp))
                .padding(20.dp)
        )

        // 余白
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
        )

        // 背景に枠線を追加する
        Text(
            text = "Hello",
            modifier = Modifier
                .background(Color.LightGray, RoundedCornerShape(20.dp))
                .border(2.dp, Color.DarkGray, RoundedCornerShape(20.dp))
                .padding(20.dp)
        )

        // 余白
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
        )

        // コンポーネントのサイズとオフセットの位置を調整
        Text(
            text = "Hello",
            modifier = Modifier
                .size(120.dp, 80.dp)
                .offset(20.dp, 20.dp)
                .background(Color.LightGray, RoundedCornerShape(20.dp))
                .border(2.dp, Color.DarkGray, RoundedCornerShape(20.dp))
                .padding(20.dp)
        )
    }
}
