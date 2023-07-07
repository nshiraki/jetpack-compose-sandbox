package com.example.viewmodelex

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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

// ViewModelを利用し、Jetpack ComposeとViewModelを連携する処理を行う
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
fun AppScreen(viewModel: AppScreenViewModel = viewModel()) {
    // ViewModelで保持しているLiveDataをStateとして扱い監視する
    val count = viewModel.count.observeAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // カウント数表示
        Text(
            color = Color.Black,
            text = "Count: ${count.value}",
            modifier = Modifier.padding(20.dp),
            style = TextStyle(fontSize = 24.sp)
        )

        // カウント加算ボタン
        Button(
            onClick = { viewModel.countUp() }
        ) {
            Text(
                text = "Count up",
                style = TextStyle(fontSize = 24.sp)
            )
        }
    }
}
