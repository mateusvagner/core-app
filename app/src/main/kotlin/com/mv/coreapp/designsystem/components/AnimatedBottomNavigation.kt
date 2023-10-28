package com.mv.coreapp.designsystem.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedBottomNavigation(
    isVisible: Boolean,
    content: @Composable () -> Unit
) {
    val density = LocalDensity.current

    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically {
            with(density) { 80.dp.roundToPx() }
        },
        exit = slideOutVertically {
            with(density) { 85.dp.roundToPx() }
        }
    ) {
        content()
    }
}

@Composable
@Preview
private fun AnimatedBottomNavigationPreview() {
    AnimatedBottomNavigation(isVisible = true) {
        Text(text = "AnimatedBottomNavigation")
    }
}
