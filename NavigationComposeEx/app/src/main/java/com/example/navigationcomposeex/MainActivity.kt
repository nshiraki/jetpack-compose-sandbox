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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

// Navigation Composeを利用して画面遷移の処理を行う
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
                onButtonClick = { text, id ->
                    // 特定の画面へ遷移
                    navController.navigate("screen2/$text/$id")
                }
            )
        }
        composable(
            route = "screen2/{text}/{id}",
            arguments = listOf(
                navArgument("text") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType },
            )
        ) { backStackEntry ->
            val text = backStackEntry.arguments?.getString("text") ?: ""
            val id = backStackEntry.arguments?.getInt("id") ?: 0

            Screen2(
                text = text, id = id,
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
fun Screen1(onButtonClick: (String, Int) -> Unit = { _, _ -> }) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Screen1", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onButtonClick("Good morning", 1) }) {
            Text(text = "1: Good morning")
        }

        Button(onClick = { onButtonClick("Good afternoon", 2) }) {
            Text(text = "2: Good afternoon")
        }

        Button(onClick = { onButtonClick("Good evening", 3) }) {
            Text(text = "3: Good afternoon")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen2(text: String = "text", id: Int = 0, onButtonClick: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "$id: $text", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onButtonClick) {
            Text(text = "Back to Screen1")
        }
    }
}
