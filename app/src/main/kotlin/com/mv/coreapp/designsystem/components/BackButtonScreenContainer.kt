package com.mv.coreapp.designsystem.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BackButtonScreenContainer(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        BackButtonHeader(
            modifier = Modifier.fillMaxWidth(),
            onBackPressed = onBackPressed
        )

        content()
    }
}