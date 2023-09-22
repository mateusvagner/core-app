package com.mv.coreapp.presentation.student.students

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mv.coreapp.designsystem.theme.CoreAppTheme

@Composable
fun StudentsScreen(
    modifier: Modifier = Modifier,
    onEvent: (StudentsScreenEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Students Screen")
        Button(onClick = {
            onEvent(
                StudentsScreenEvent.StudentClicked(
                    studentId = "studentId"
                )
            )
        }) {
            Text(text = "Go to Student Detail")
        }
    }
}

@Composable
@Preview
fun StudentsScreenPreview() {
    CoreAppTheme {
        StudentsScreen(
            onEvent = {}
        )
    }
}
