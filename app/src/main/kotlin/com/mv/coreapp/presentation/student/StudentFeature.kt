package com.mv.coreapp.presentation.student

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.mv.coreapp.navigation.Route
import com.mv.coreapp.presentation.student.studentdetail.StudentDetailScreenArgs
import com.mv.coreapp.presentation.student.studentdetail.studentDetailScreen
import com.mv.coreapp.presentation.student.students.studentsScreen

sealed class StudentFeatureRoute(val route: String) {

    data object Students : StudentFeatureRoute("Students")

    data object StudentDetail :
        StudentFeatureRoute("StudentDetail/{${StudentDetailScreenArgs.STUDENT_ID}}") {
        fun fromStudentsToStudentDetail(studentId: String) = "StudentDetail/$studentId"
    }
}

fun NavGraphBuilder.studentFeature(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    navigation(
        startDestination = Route.StudentsFeature.startDestination,
        route = Route.StudentsFeature.route
    ) {
        studentsScreen(
            modifier = modifier,
            navController = navController
        )

        studentDetailScreen(
            modifier = modifier,
            navController = navController
        )
    }
}