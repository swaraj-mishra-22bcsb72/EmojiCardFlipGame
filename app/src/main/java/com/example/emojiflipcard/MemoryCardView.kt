package com.example.emojiflipcard

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MemoryCardView(card: MemoryCard, width: Dp, height: Dp, onClick: () -> Unit) {
    val isFront = card.isFaceUp || card.isMatched

    val gradient = Brush.verticalGradient(
        colors = if (isFront) {
            listOf(Color(0xFF424242), Color(0xFF212121))
        } else {
            listOf(Color(0xFF68049E), Color(0xD57C1AA1))
        }
    )

    Box(
        modifier = Modifier
            .size(width * 0.85f, height * 0.85f) // Slightly smaller
            .clip(RoundedCornerShape(12.dp))
            .background(brush = gradient)
            .clickable(enabled = !card.isFaceUp && !card.isMatched) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (isFront) {
            Text(text = card.emoji, fontSize = 26.sp, color = Color.White)
        } else {
            Text("?", fontSize = 20.sp, color = Color.White.copy(alpha = 0.5f))
        }
    }
}
