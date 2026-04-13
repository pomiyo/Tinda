package com.example.tinda.ui.components

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class BottomBarCutoutShape(
    private val fabRadius: Float,
    private val cornerRadius: Float
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val path = Path()

        val width = size.width
        val height = size.height

        val centerX = width / 2

        val extraSpace = fabRadius * 0.8f
        val cutoutRadius = fabRadius + extraSpace

        val controlOffset = cutoutRadius * 0.6f

        // 🔥 NEW: controls how deep the dip is
        val depthFactor = 0.65f   // 👈 tweak this (0.4 = shallow, 0.7 = deep)
        val cutoutDepth = cutoutRadius * depthFactor

        path.moveTo(0f, cornerRadius)

        // Top-left corner
        path.quadraticBezierTo(0f, 0f, cornerRadius, 0f)

        // Line to left of cutout
        path.lineTo(centerX - cutoutRadius, 0f)

        // LEFT CURVE
        path.cubicTo(
            centerX - cutoutRadius + controlOffset, 0f,
            centerX - controlOffset, cutoutDepth,
            centerX, cutoutDepth
        )

        // RIGHT CURVE
        path.cubicTo(
            centerX + controlOffset, cutoutDepth,
            centerX + cutoutRadius - controlOffset, 0f,
            centerX + cutoutRadius, 0f
        )

        // Continue right
        path.lineTo(width - cornerRadius, 0f)

        // Top-right corner
        path.quadraticBezierTo(width, 0f, width, cornerRadius)

        path.lineTo(width, height)
        path.lineTo(0f, height)

        path.close()

        return Outline.Generic(path)
    }
}