package com.mv.coreapp.presentation.student.studentdetail

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mv.coreapp.presentation.student.StudentFeatureRoute

fun NavGraphBuilder.studentDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    composable(
        route = StudentFeatureRoute.StudentDetail.route,
        arguments = listOf(
            navArgument(StudentDetailScreenArgs.STUDENT_ID) {
                type = NavType.StringType
            }
        )
    ) {
        val viewModel: StudentDetailViewModel = hiltViewModel()
        val screenState by viewModel.state.collectAsState()

        StudentDetailScreenContent(
            modifier = modifier,
            screenState = screenState,
            onEvent = { event ->
                when (event) {
                    is StudentDetailEvent.BackPressed -> {
                        navController.popBackStack()
                    }
                }
            }
        )
    }
}

fun NavController.navigateToStudentDetail(studentId: String) {
    navigate(StudentFeatureRoute.StudentDetail.fromStudentsToStudentDetail(studentId))
}

internal class StudentDetailScreenArgs(val studentId: String) {
    constructor(
        savedStateHandle: SavedStateHandle
    ) : this(
        studentId = checkNotNull(savedStateHandle[STUDENT_ID])
    )

    companion object {
        const val STUDENT_ID = "studentDetailScreenStudentId"
    }
}
