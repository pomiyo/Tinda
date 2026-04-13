package com.example.tinda.ui

import android.graphics.pdf.models.ListItem
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ListScreen(modifier: Modifier = Modifier) {
    val items = List(100) { it }

    LazyColumn(modifier = modifier) {
        itemsIndexed(items) { index, _ ->
            ListItem(position = index)
        }
    }

}

@Composable
fun ListItem(position: Int) {
    Text(
        text = "This is item #$position",
        modifier = Modifier.padding(20.dp)
    )
}

@Preview(showSystemUi = true)
@Composable
fun ListScreenPreview() {
    ListScreen(modifier = Modifier)
}