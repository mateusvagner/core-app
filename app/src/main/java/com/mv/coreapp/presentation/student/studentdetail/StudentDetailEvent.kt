package com.mv.coreapp.presentation.student.studentdetail

sealed class StudentDetailEvent {
    data object StudentLoad : StudentDetailEvent()
}
