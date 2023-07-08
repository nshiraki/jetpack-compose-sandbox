package com.example.alertdialogex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// AlertDialogを利用した処理を行う
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
    // ダイアログの表示・非表示を管理
    val isOpenDialog = remember { mutableStateOf(false) }
    // ダイアログの結果を格納
    val dialogResult = remember { mutableStateOf("unknown") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        // ダイアログを表示するボタン
        Button(
            onClick = { isOpenDialog.value = true },
            modifier = Modifier.padding(48.dp)
        ) {
            Text(text = "Show Dialog")
        }

        // ダイアログの結果を表示
        Text(text = "result: ${dialogResult.value}", fontSize = 24.sp)

        if (isOpenDialog.value) {
            // ダイアログの表示
            AlertDialog(
                onDismissRequest = {
                    dialogResult.value = "Tap outside area of dialog"
                    isOpenDialog.value = false
                },
                confirmButton = {
                    Button(
                        onClick = {
                            dialogResult.value = "OK button clicked"
                            isOpenDialog.value = false
                        }
                    ) { Text("OK") }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            dialogResult.value = "Cancel button clicked"
                            isOpenDialog.value = false
                        }
                    ) { Text("Cancel") }
                },
                title = { Text(text = "Dialog Title") },
                text = { Text("Dialog Text") },
            )
        }
    }
}
