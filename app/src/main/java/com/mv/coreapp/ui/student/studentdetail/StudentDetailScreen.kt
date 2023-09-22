package com.mv.coreapp.ui.student.studentdetail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mv.coreapp.designsystem.theme.CoreAppTheme

@Composable
fun StudentDetailScreen(modifier: Modifier = Modifier, studentId: String) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Text(text = "Students id: $studentId")
    }
}

@Composable
@Preview
fun StudentDetailScreenPreview() {
    CoreAppTheme {
        StudentDetailScreen(studentId = "123aaAAbbBBccCC")
    }
}
