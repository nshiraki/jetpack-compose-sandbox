package com.example.boxex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.boxex.ui.theme.BoxExTheme

// Boxを利用して任意の位置にコンポーネントを配置する処理を行う
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.Cyan))
                // 親のBoxと同じサイズにして、上下のみにpaddingをかけて配置
                Box(
                    Modifier
                        .matchParentSize()
                        .padding(top = 50.dp, bottom = 50.dp)
                        .background(Color.Yellow)
                )
                // 親のBoxと同じサイズにして、上下左右にpaddingをかけて配置
                Box(
                    Modifier
                        .matchParentSize()
                        .padding(100.dp)
                        .background(Color.Magenta)
                )
                // 子のコンポーネント側でアライメントを指定して中央に配置
                Box(
                    Modifier
                        .align(Alignment.Center)
                        .size(300.dp, 300.dp)
                        .background(Color.Green)
                )
                // 子のコンポーネント側でアライメントを指定して左上に配置
                Box(
                    Modifier
                        .align(Alignment.TopStart)
                        .size(150.dp, 150.dp)
                        .background(Color.Red)
                )
                // 子のコンポーネント側でアライメントを指定して右下に配置
                Box(
                    Modifier
                        .align(Alignment.BottomEnd)
                        .size(150.dp, 150.dp)
                        .background(Color.Blue)
                )
            }
        }
    }
}
