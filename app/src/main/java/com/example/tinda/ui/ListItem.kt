package com.example.tinda.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tinda.ui.theme.Purple40

@Composable
fun ListItem(modifier: Modifier = Modifier) {

    Surface (
        modifier = Modifier.fillMaxSize(),
    ) {
        ElevatedCard(
            onClick = { /* Do something */ },
            modifier = Modifier.size(width = 185.dp, height = 225.dp),
            shape = ShapeDefaults.ExtraLarge
        ) {

            Box(Modifier.fillMaxSize()) {
                Text("Clickable", Modifier.align(Alignment.Center))
            }


        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ListItemPreview() {

    ListItem()

}