package com.mv.coreapp.ui.student.students

sealed class StudentsScreenEvent {
    data class StudentClicked(val studentId: String) : StudentsScreenEvent()
}
