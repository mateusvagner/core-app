package com.mv.coreapp.presentation.student.students

import androidx.navigation.NavHostController
import com.mv.coreapp.navigation.Route

object StudentsScreenEventHandler {
    fun handleEvent(
        event: StudentsScreenEvent,
        navController: NavHostController,
        viewModel: StudentsViewModel
    ) {
        when (event) {
            is StudentsScreenEvent.StudentClicked -> {
                navController.navigate(
                    Route.StudentDetail.fromStudentsToStudentDetail(event.studentId)
                )
            }
        }
    }
}
