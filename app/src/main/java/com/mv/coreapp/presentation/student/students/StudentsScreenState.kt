package com.mv.coreapp.presentation.student.students

import com.mv.coreapp.domain.model.Student

sealed class StudentsScreenState {
    data object Loading : StudentsScreenState()
    data class Error(val message: String) : StudentsScreenState()
    data object Empty : StudentsScreenState()
    data class Success(val students: List<Student>) : StudentsScreenState()
}
