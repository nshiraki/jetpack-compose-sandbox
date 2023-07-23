package com.example.lazyverticalgridex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazyverticalgridex.ui.theme.LazyVerticalGridExTheme

// LazyVerticalGridコンポーネントを利用した処理を行う
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyVerticalGridExTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppScreen() {
    // 選択したアイテムのインデックスを格納
    val selectedIndex = remember { mutableStateOf(-1) }

    // 垂直スクロールのグリッドを生成
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        columns = GridCells.Fixed(count = 2), // 列の固定数
        verticalArrangement = Arrangement.spacedBy(space = 16.dp),  // 各アイテム間の上下の余白
        horizontalArrangement = Arrangement.spacedBy(space = 16.dp), // 各アイテム間の左右の余白
        contentPadding = PaddingValues(all = 16.dp) // レイアウト全体の余白
    ) {
        // グリッドのアイテムを生成
        items(count = 10) { index ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f)
                    .background(color = Color.White, shape = RoundedCornerShape(size = 4.dp))
                    .clickable {
                        // アイテムのクリック処理
                        selectedIndex.value = index
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$index",
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp
                )
            }
        }
    }

    if (selectedIndex.value >= 0) {
        AlertDialog(
            onDismissRequest = { selectedIndex.value = -1 },
            confirmButton = {
                TextButton(onClick = { selectedIndex.value = -1 }) {
                    Text("OK")
                }
            },
            text = {
                Text(
                    text = "Index ${selectedIndex.value} is clicked.",
                    fontSize = 24.sp,
                )
            }
        )
    }
}
