package com.example.textfieldex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// TextFieldコンポーネントを利用した処理を作成
// TextFieldとOutlinedTextFieldの2種類のコンポーネントが用意されているが、今回はOutlinedTextFieldを利用
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AppScreen() {
    val text = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        OutlinedTextField(
            value = text.value,
            onValueChange = { newValue ->
                // 新しく変更されたテキストを格納
                text.value = newValue
            },
            // label: 入力欄の表示。フォーカスが当たると小さくなり、外枠部分に表示される
            label = { Text(text = "Label") },
            // placeholder: 説明文の表示。入力文字がない場合に表示され、文字を入力すると表示が消える。
            placeholder = { Text(text = "ここにテキストを入力", color = Color.Gray) },
        )

        // 余白
        Spacer(modifier = Modifier.height(16.dp))

        // 変更時に格納したテキストを表示
        Text(
            text = "Input text: ${text.value}",
            fontSize = 16.sp
        )
    }
}


