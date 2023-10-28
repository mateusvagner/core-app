package com.mv.coreapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mv.coreapp.presentation.calendar.CalendarScreen
import com.mv.coreapp.presentation.financial.FinancialScreen
import com.mv.coreapp.presentation.more.MoreScreen
import com.mv.coreapp.presentation.student.StudentFeatureRoute
import com.mv.coreapp.presentation.student.studentdetail.studentDetailScreen
import com.mv.coreapp.presentation.student.students.StudentsScreenStateful

@Composable
fun CoreAppNavHost(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.StudentsFeature.route
    ) {
        calendarFeature()

        studentFeature(
            modifier = modifier,
            navController = navController
        )

        financialFeature()

        moreFeature()
    }
}

private fun NavGraphBuilder.calendarFeature() {
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
}

private fun NavGraphBuilder.studentFeature(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    navigation(
        startDestination = Route.StudentsFeature.startDestination,
        route = Route.StudentsFeature.route
    ) {
        composable(
            route = StudentFeatureRoute.Students.route
        ) {
            StudentsScreenStateful(
                modifier = modifier,
                navController = navController
            )
        }

        studentDetailScreen(modifier = modifier)
    }
}

private fun NavGraphBuilder.financialFeature() {
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
}

private fun NavGraphBuilder.moreFeature() {
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

