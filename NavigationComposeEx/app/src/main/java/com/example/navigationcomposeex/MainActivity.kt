package com.example.navigationcomposeex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetupNavHost()
        }
    }
}

// 画面遷移のセットアップを行う
@Composable
fun SetupNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "screen1"
    ) {
        // 画面遷移に関するコンポーザブルを登録
        composable(route = "screen1") {
            Screen1(
                onButtonClick = {
                    // 特定の画面へ遷移
                    navController.navigate("screen2")
                }
            )
        }
        composable(route = "screen2") {
            Screen2(
                onButtonClick = {
                    // アプリ内の前の画面に戻る
                    navController.navigateUp()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen1(onButtonClick: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Screen1", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onButtonClick) {
            Text(text = "Go to Screen2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen2(onButtonClick: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Screen2", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onButtonClick) {
            Text(text = "Back to Screen1")
        }
    }
}
