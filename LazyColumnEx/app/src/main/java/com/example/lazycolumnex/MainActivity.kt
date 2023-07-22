package com.example.lazycolumnex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazycolumnex.ui.theme.LazyColumnExTheme

// LazyColumnコンポーネントを利用した処理を行う
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnExTheme {
                AppScreen()
            }
        }
    }
}

@Composable
fun AppScreen() {
    val fruits = createFruitsList()

    val selectedIndex = remember { mutableStateOf(-1) }

    FruitsList(items = fruits, onClickItem = { index ->
        selectedIndex.value = index
    })

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

@Composable
fun FruitsList(items: List<Fruits>, onClickItem: (Int) -> Unit) {

    LazyColumn(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        itemsIndexed(items) { index, item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(4.dp))
                    .clickable { onClickItem(index) }
            ) {
                Image(
                    painter = painterResource(id = item.imageResource),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(48.dp)
                )
                Text(
                    text = "$index: ${item.name}",
                    fontSize = 24.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFruitsList() {
    LazyColumnExTheme {
        FruitsList(items = createFruitsList(), onClickItem = { })
    }
}

fun createFruitsList() = listOf(
    Fruits("apple", R.drawable.fruit_apple),
    Fruits("banana", R.drawable.fruit_banana),
    Fruits("grape", R.drawable.fruit_grape),
    Fruits("muscat", R.drawable.fruit_muscat),
    Fruits("orange", R.drawable.fruit_orange),
    Fruits("pineapple", R.drawable.fruit_pineapple),
)

data class Fruits(val name: String, val imageResource: Int)
