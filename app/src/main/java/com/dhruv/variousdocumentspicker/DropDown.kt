package com.dhruv.variousdocumentspicker

import android.text.style.DynamicDrawableSpan
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DropDownScreen(modifier: Modifier = Modifier) {


    var expanded by remember { mutableStateOf(false) }
    val items = listOf("Item 1", "Item 2", "Item 3")
    var selectedItem by remember { mutableStateOf(items[0]) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Dropdown Menu
        Box(modifier = Modifier.padding(16.dp)) {
            Button(
                onClick = { expanded = !expanded },
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = selectedItem)
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.width(200.dp)
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedItem = item
                            expanded = false
                        }
                    )
                }
            }
        }
    }

}

@Preview
@Composable
private fun dds() {
    DropDownScreen()
}
