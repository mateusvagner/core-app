package com.mv.coreapp.navigation

import com.mv.coreapp.presentation.calendar.CalendarFeatureRoute
import com.mv.coreapp.presentation.financial.FinancialFeatureRoute
import com.mv.coreapp.presentation.more.MoreFeatureRoute
import com.mv.coreapp.presentation.student.StudentFeatureRoute

sealed class Route(val route: String, val startDestination: String) {
    data object CalendarFeature : Route(
            route = "CalendarFeature",
            startDestination = CalendarFeatureRoute.Calendar.route
        )

    data object StudentsFeature : Route(
        route = "StudentsFeature",
        startDestination = StudentFeatureRoute.Students.route
    )

    data object FinancialFeature : Route(
        route = "FinancialFeature",
        startDestination = FinancialFeatureRoute.Financial.route
    )

    data object MoreFeature : Route(
        route = "MoreFeature",
        startDestination = MoreFeatureRoute.More.route
    )
}
