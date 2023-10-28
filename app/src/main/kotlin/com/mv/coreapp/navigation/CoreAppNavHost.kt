package com.mv.coreapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.mv.coreapp.presentation.calendar.CalendarScreen
import com.mv.coreapp.presentation.financial.FinancialScreen
import com.mv.coreapp.presentation.more.MoreScreen
import com.mv.coreapp.presentation.student.studentdetail.StudentDetailScreenStateful
import com.mv.coreapp.presentation.student.students.StudentsScreenStateful

@Composable
fun CoreAppNavHost(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.StudentsFeature.route
    ) {
        navigation(
            startDestination = Route.CalendarFeature.startDestination,
            route = Route.CalendarFeature.route
        ) {
            composable(
                route = CalendarFeatureRoute.Calendar.route
            ) {
                CalendarScreen()
            }
        }

        navigation(
            startDestination = Route.StudentsFeature.startDestination,
            route = Route.StudentsFeature.route
        ) {
            composable(
                route = StudentsFeatureRoute.Students.route
            ) {
                StudentsScreenStateful(
                    modifier = modifier,
                    navController = navController
                )
            }

            composable(
                route = StudentsFeatureRoute.StudentDetail.route,
                arguments = listOf(
                    navArgument(RouteKeys.STUDENT_DETAIL_PARAM) {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                StudentDetailScreenStateful(modifier = modifier, backStackEntry = backStackEntry)
            }
        }

        navigation(
            startDestination = Route.FinancialFeature.startDestination,
            route = Route.FinancialFeature.route
        ) {
            composable(
                route = FinancialFeatureRoute.Financial.route
            ) {
                FinancialScreen()
            }
        }

        navigation(
            startDestination = Route.MoreFeature.startDestination,
            route = Route.MoreFeature.route
        ) {
            composable(
                route = MoreFeatureRoute.More.route
            ) {
                MoreScreen()
            }
        }
    }
}
