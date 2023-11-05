package com.mv.coreapp.presentation.student.students

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.mv.coreapp.presentation.student.StudentFeatureRoute
import com.mv.coreapp.presentation.student.studentdetail.navigateToStudentDetail

fun NavGraphBuilder.studentsScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    composable(
        route = StudentFeatureRoute.Students.route
    ) {
        val viewModel: StudentsViewModel = hiltViewModel()
        val screenState by viewModel.state.collectAsState()

        StudentsScreenContent(
            modifier = modifier,
            screenState = screenState,
            onEvent = { event ->
                when (event) {
                    is StudentsScreenEvent.StudentPressed -> {
                        navController.navigateToStudentDetail(event.studentId)
                    }
                }
            }
        )
    }
}
