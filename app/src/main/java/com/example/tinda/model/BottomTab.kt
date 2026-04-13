package com.example.tinda.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomTab(
    val icon: ImageVector,
    val selectedIcon: ImageVector = icon
) {
    object Home : BottomTab(Icons.Default.Home)
    object Person : BottomTab(Icons.Default.Person)
    object Menu : BottomTab(Icons.Default.Menu)
    object Favorite : BottomTab(Icons.Default.Favorite)
}