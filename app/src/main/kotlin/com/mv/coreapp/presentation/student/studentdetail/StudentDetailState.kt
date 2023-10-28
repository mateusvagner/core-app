package com.mv.coreapp.presentation.student.studentdetail

import com.mv.coreapp.domain.model.Student

sealed class StudentDetailState {
    data object Loading : StudentDetailState()
    data class Error(val message: String) : StudentDetailState()
    data class Success(val student: Student) : StudentDetailState()
}
