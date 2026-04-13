package com.example.tinda.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tinda.model.BottomTab
import com.example.tinda.ui.components.CategoryRow
import com.example.tinda.ui.components.CustomBottomBar
import com.example.tinda.ui.components.FoodGrid
import com.example.tinda.ui.components.HeaderSection
import com.example.tinda.ui.components.SearchBar

@Composable
fun HomeScreen() {
    var query by remember { mutableStateOf("") }
    var selectedTab by remember { mutableStateOf<BottomTab>(BottomTab.Home) }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(16.dp)
        ) {
            HeaderSection()
            Spacer(modifier = Modifier.height(16.dp))

            SearchBar(
                query = query,
                onQueryChange = { query = it }
            )
            Spacer(modifier = Modifier.height(16.dp))

            CategoryRow()
            Spacer(modifier = Modifier.height(16.dp))

            FoodGrid()
        }

        CustomBottomBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
