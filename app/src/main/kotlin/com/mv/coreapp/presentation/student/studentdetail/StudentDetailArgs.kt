package com.mv.coreapp.presentation.student.studentdetail

import androidx.lifecycle.SavedStateHandle

internal class StudentDetailArgs(val studentId: String) {
    constructor(
        savedStateHandle: SavedStateHandle
    ) : this(
        studentId = checkNotNull(savedStateHandle[STUDENT_ID])
    )

    companion object {
        const val STUDENT_ID = "studentId"
    }
}
