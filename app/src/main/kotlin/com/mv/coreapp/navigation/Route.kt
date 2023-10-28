package com.mv.coreapp.navigation

import com.mv.coreapp.navigation.RouteKeys.STUDENT_DETAIL_PARAM

object RouteKeys {
    const val STUDENT_DETAIL_PARAM = "studentDetailParam"
}

sealed class Route(val route: String, val startDestination: String) {
    data object CalendarFeature : Route(
            route = "CalendarFeature",
            startDestination = CalendarFeatureRoute.Calendar.route
        )

    data object StudentsFeature : Route(
        route = "StudentsFeature",
        startDestination = StudentsFeatureRoute.Students.route
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

sealed class CalendarFeatureRoute(val route: String) {

    data object Calendar : CalendarFeatureRoute("Calendar")
}

sealed class StudentsFeatureRoute(val route: String) {

    data object Students : StudentsFeatureRoute("Students")
    data object StudentDetail : StudentsFeatureRoute("StudentDetail/{$STUDENT_DETAIL_PARAM}") {
        fun fromStudentsToStudentDetail(studentId: String) = "studentDetail/$studentId"
    }
}

sealed class FinancialFeatureRoute(val route: String) {

    data object Financial : FinancialFeatureRoute("Financial")
}

sealed class MoreFeatureRoute(val route: String) {

    data object More : MoreFeatureRoute("More")
}
