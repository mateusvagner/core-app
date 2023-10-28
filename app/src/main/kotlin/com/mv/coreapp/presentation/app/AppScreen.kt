package com.mv.coreapp.presentation.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import com.mv.coreapp.presentation.student.students.StudentsScreenStateful

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
            StudentsScreenStateful(
                modifier = modifier,
                navController = navController
            )
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
            StudentDetailScreenStateful(modifier = modifier, backStackEntry = backStackEntry)
        }
    }
}
