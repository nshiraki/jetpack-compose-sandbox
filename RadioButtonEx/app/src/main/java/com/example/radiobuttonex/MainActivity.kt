package com.example.radiobuttonex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// RadioButtonを利用した処理を行う
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
    val radioOptions = listOf("item1", "item2", "item3", "item4")
    val selectedItem = remember { mutableStateOf(radioOptions[0]) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // 選択中のアイテムを表示
        Text(text = "Selected item: ${selectedItem.value}", fontSize = 24.sp)

        // 余白
        Spacer(modifier = Modifier.height(16.dp))

        // ラジオボタンのグループを生成
        Column(modifier = Modifier.selectableGroup()) {
            // ラジオボタンを生成
            radioOptions.forEach { label ->
                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .wrapContentWidth()
                        .selectable(
                            selected = (label == selectedItem.value),
                            onClick = { selectedItem.value = label },
                            role = Role.RadioButton
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        modifier = Modifier.padding(end = 8.dp),
                        selected = (label == selectedItem.value),
                        onClick = null // RadioButtonでは入力イベントを処理しない
                    )
                    Text(text = label, modifier = Modifier.padding(8.dp), fontSize = 24.sp)
                }
            }
        }
    }
}
