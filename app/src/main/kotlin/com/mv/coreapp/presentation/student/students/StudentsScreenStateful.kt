package com.mv.coreapp.presentation.student.students

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mv.coreapp.navigation.StudentFeatureRoute

@Composable
fun StudentsScreenStateful(
    modifier: Modifier,
    navController: NavHostController
) {
    val viewModel: StudentsViewModel = hiltViewModel()

    StudentsScreenStateful(
        modifier = modifier,
        viewModel = viewModel,
        onNavigateToStudentDetail = { studentId ->
            navController.navigate(
                StudentFeatureRoute.StudentDetail.fromStudentsToStudentDetail(studentId)
            )
        }
    )
}

@Composable
private fun StudentsScreenStateful(
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
