package com.mv.coreapp.presentation.student

import com.mv.coreapp.presentation.student.studentdetail.StudentDetailScreenArgs

sealed class StudentFeatureRoute(val route: String) {

    data object Students : StudentFeatureRoute("Students")

    data object StudentDetail : StudentFeatureRoute("StudentDetail/{${StudentDetailScreenArgs.STUDENT_ID}}") {
        fun fromStudentsToStudentDetail(studentId: String) = "StudentDetail/$studentId"
    }
}
