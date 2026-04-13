package com.example.tinda.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.tinda.R

@Composable
fun FoodGrid() {
    val bottomPadding = 120.dp

    val items = listOf(
        Food("Cheeseburger", "Wendy's Burger", 4.9, R.drawable.ic_launcher_foreground),
        Food("Hamburger", "Veggie Burger", 4.8, R.drawable.ic_launcher_foreground),
        Food("Hamburger", "Chicken Burger", 4.6, R.drawable.ic_launcher_foreground),
        Food("Hamburger", "Fried Chicken Burger", 4.5, R.drawable.ic_launcher_foreground),
    )

    val extraItems = List(100) { index ->
        Food("Item $index", "Wendy's Burger", 2.0, R.drawable.ic_launcher_foreground)
    }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 160.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(bottom = 120.dp)
    ) {
        items(items + extraItems) { item ->
            FoodCard(item)
        }
    }
}