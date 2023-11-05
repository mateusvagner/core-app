package com.mv.coreapp.designsystem.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun Modifier.basePadding() = this.fillMaxSize().padding(16.dp)

fun Modifier.baseHorizontalPadding() = this.fillMaxSize().padding(horizontal = 16.dp)