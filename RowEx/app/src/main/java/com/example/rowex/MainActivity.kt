package com.example.rowex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Rowを利用してコンポーネントを横に並べる処理を行う
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row() {
                Canvas(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Cyan), onDraw = {}
                )
                Canvas(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Black), onDraw = {}
                )
                Canvas(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Yellow), onDraw = {}
                )
                Canvas(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.LightGray), onDraw = {}
                )
            }
        }
    }
}
