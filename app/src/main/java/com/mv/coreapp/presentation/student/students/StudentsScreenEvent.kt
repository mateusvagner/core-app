package com.mv.coreapp.presentation.student.students

sealed class StudentsScreenEvent {
    data class StudentClicked(val studentId: String) : StudentsScreenEvent()
}
