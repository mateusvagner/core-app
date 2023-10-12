package com.mv.coreapp.presentation.student.studentdetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun StudentDetailScreenStateful(
    modifier: Modifier,
    studentId: String,
    viewModel: StudentDetailViewModel
) {
    val screenState by viewModel.state.collectAsState()

    LaunchedEffect(key1 = "StudentDetailScreenStateful") {
        viewModel.loadStudent(studentId = studentId)
    }

    StudentDetailScreen(
        modifier = modifier,
        screenState = screenState,
        onEvent = { }
    )
}
