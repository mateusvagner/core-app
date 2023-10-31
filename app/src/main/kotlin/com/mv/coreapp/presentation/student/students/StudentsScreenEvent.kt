package com.mv.coreapp.presentation.student.students

sealed class StudentsScreenEvent {
    data class StudentPressed(val studentId: String) : StudentsScreenEvent()
}
