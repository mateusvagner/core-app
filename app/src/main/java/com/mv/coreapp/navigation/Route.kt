package com.mv.coreapp.navigation

import com.mv.coreapp.navigation.RouteKeys.STUDENT_DETAIL_PARAM

object RouteKeys {
    const val STUDENT_DETAIL_PARAM = "studentDetailParam"
}

sealed class Route(val route: String) {

    data object Calendar : Route("Calendar")
    data object Students : Route("Students")
    data object Financial : Route("Financial")
    data object More : Route("More")

    data object StudentDetail : Route("StudentDetail/{$STUDENT_DETAIL_PARAM}") {
        fun fromStudentsToStudentDetail(studentId: String) = "studentDetail/$studentId"
    }
}
