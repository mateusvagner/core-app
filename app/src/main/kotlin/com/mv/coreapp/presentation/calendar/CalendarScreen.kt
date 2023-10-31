package com.mv.coreapp.presentation.calendar

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.calendarScreen() {
    composable(
        route = CalendarFeatureRoute.Calendar.route
    ) {
        CalendarScreenContent()
    }
}
