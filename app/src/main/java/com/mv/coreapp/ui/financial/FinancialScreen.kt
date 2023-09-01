package com.mv.coreapp.ui.financial

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mv.coreapp.ui.theme.CoreAppTheme

@Composable
fun FinancialScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Text(text = "Financial Screen")
    }
}

@Composable
@Preview
fun MoreScreenPreview() {
    CoreAppTheme {
        FinancialScreen()
    }
}
