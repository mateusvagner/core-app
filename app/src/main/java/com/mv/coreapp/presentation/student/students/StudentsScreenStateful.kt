package com.mv.coreapp.presentation.student.students

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun StudentsScreenStateful(
    modifier: Modifier,
    viewModel: StudentsViewModel,
    onNavigateToStudentDetail: (String) -> Unit
) {
    val screenState by viewModel.state.collectAsState()

    StudentsScreen(
        modifier = modifier,
        screenState = screenState,
        onEvent = { event ->
            when (event) {
                is StudentsScreenEvent.StudentClicked -> {
                    onNavigateToStudentDetail(event.studentId)
                }
            }
        }
    )
}
