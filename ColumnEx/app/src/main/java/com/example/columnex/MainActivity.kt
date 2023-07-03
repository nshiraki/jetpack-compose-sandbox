package com.example.columnex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Columnを利用してコンポーネントを縦に並べる処理を作成
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                ColumnItem(color = Color.Cyan)
                ColumnItem(color = Color.Black)
                ColumnItem(color = Color.Yellow)
                ColumnItem(color = Color.LightGray)
            }
        }
    }
}

@Composable
fun ColumnItem(color: Color) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        drawRect(color = color)
    }
}
