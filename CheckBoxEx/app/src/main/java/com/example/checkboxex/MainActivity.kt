package com.example.checkboxex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.checkboxex.ui.theme.CheckBoxExTheme

// チェックボックスを利用した処理を行う
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckBoxExTheme {
                AppScreen()
            }
        }
    }
}

@Composable
fun AppScreen() {

    Column(horizontalAlignment = Alignment.Start) {
        GroupedCheckBox()
    }
}

@Composable
fun GroupedCheckBox() {
    val items = listOf("a", "b", "c", "d")
    val result = remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.Start) {

        // グループ化したチェックボックスを生成
        items.forEach { item ->
            val checkedState = remember { mutableStateOf(true) }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { isChecked ->
                        checkedState.value = isChecked
                        result.value = if (isChecked) {
                            "onCheckedChange: $item= checked"
                        } else {
                            "onCheckedChange: $item= unchecked"
                        }
                    }
                )
                Text(text = item)
            }
        }

        // 余白
        Spacer(modifier = Modifier.height(16.dp))

        // チェックボックスのonCheckedChangeが呼ばれたタイミングで更新される結果
        Text(
            text = result.value,
            fontSize = 24.sp,
            modifier = Modifier.padding(all = 16.dp)
        )
    }
}
