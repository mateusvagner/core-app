package com.mv.coreapp.presentation.calendar

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.mv.coreapp.navigation.Route

sealed class CalendarFeatureRoute(val route: String) {

    data object Calendar : CalendarFeatureRoute("Calendar")
}

fun NavGraphBuilder.calendarFeature() {
    navigation(
        startDestination = Route.CalendarFeature.startDestination,
        route = Route.CalendarFeature.route
    ) {
        calendarScreen()
    }
}