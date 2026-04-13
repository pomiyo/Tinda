package com.example.tinda.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.tinda.model.BottomTab


@Composable
fun CustomBottomBar(
    modifier: Modifier = Modifier,
    selectedTab: BottomTab,
    onTabSelected: (BottomTab) -> Unit
) {
    val fabSize = 64.dp

    val tabs = listOf(
        BottomTab.Home,
        BottomTab.Person,
        BottomTab.Menu,
        BottomTab.Favorite
    )

    Box(modifier = modifier.height(80.dp)) {

        // Bottom Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clip(
                    BottomBarCutoutShape(
                        fabRadius = with(LocalDensity.current) { fabSize.toPx() / 2 },
                        cornerRadius = with(LocalDensity.current) { 24.dp.toPx() }
                    )
                )
                .background(Color.Red)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                tabs.forEachIndexed { index, tab ->

                    // center gap for FAB
                    if (index == 2) {
                        Spacer(modifier = Modifier.width(64.dp))
                    }

                    val isSelected = tab == selectedTab

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        val interactionSource = remember { MutableInteractionSource() }

                        Icon(
                            imageVector = tab.icon,
                            contentDescription = null,
                            tint = if (isSelected) Color.White else Color.White.copy(alpha = 0.5f),
                            modifier = Modifier
                                .size(26.dp)
                                .clickable(
                                    interactionSource = interactionSource,
                                    indication = null // ✅ removes box ripple
                                ) {
                                    onTabSelected(tab)
                                }
                        )

                        // 🔥 DOT INDICATOR (Option 3)
                        if (isSelected) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Box(
                                modifier = Modifier
                                    .size(4.dp)
                                    .background(Color.White, CircleShape)
                            )
                        }
                    }
                }
            }
        }

        val interactionSource = remember { MutableInteractionSource() }
        val isPressed by interactionSource.collectIsPressedAsState()

        val scale by animateFloatAsState(
            targetValue = if (isPressed) 0.92f else 1f,
            label = "fabScale"
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-52).dp)
                .size(fabSize)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
                .background(Color.Red, CircleShape)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    // FAB action
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.Add, contentDescription = null, tint = Color.White)
        }
    }
}