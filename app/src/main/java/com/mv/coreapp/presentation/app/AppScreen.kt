package com.mv.coreapp.presentation.app

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mv.coreapp.navigation.Route
import com.mv.coreapp.navigation.RouteKeys
import com.mv.coreapp.presentation.calendar.CalendarScreen
import com.mv.coreapp.presentation.financial.FinancialScreen
import com.mv.coreapp.presentation.more.MoreScreen
import com.mv.coreapp.presentation.student.studentdetail.StudentDetailScreenStateful
import com.mv.coreapp.presentation.student.studentdetail.StudentDetailViewModel
import com.mv.coreapp.presentation.student.students.StudentsScreenStateful
import com.mv.coreapp.presentation.student.students.StudentsViewModel

@Composable
fun AppScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.Students.value
    ) {
        composable(
            route = Route.Calendar.value
        ) {
            CalendarScreen()
        }

        composable(
            route = Route.Students.value
        ) {
            StudentsScreenStateful(modifier, navController)
        }

        composable(
            route = Route.Financial.value
        ) {
            FinancialScreen()
        }

        composable(
            route = Route.More.value
        ) {
            MoreScreen()
        }

        composable(
            route = Route.StudentDetail.value,
            arguments = listOf(
                navArgument(RouteKeys.STUDENT_DETAIL_PARAM) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            StudentDetailScreenStateful(backStackEntry, modifier)
        }
    }
}

@Composable
private fun StudentsScreenStateful(
    modifier: Modifier,
    navController: NavHostController
) {
    val viewModel: StudentsViewModel = hiltViewModel()

    StudentsScreenStateful(
        modifier = modifier,
        viewModel = viewModel,
        onNavigateToStudentDetail = {
            navController.navigate(
                Route.StudentDetail.fromStudentsToStudentDetail(it)
            )
        }
    )
}

@Composable
private fun StudentDetailScreenStateful(
    backStackEntry: NavBackStackEntry,
    modifier: Modifier
) {
    val studentId = backStackEntry.arguments?.getString(RouteKeys.STUDENT_DETAIL_PARAM)
    studentId?.let {
        val viewModel: StudentDetailViewModel = hiltViewModel()

        StudentDetailScreenStateful(
            modifier = modifier,
            studentId = studentId,
            viewModel = viewModel
        )
    } ?: run {
        Toast.makeText(LocalContext.current, "Student Id is null", Toast.LENGTH_SHORT)
            .show()
    }
}
