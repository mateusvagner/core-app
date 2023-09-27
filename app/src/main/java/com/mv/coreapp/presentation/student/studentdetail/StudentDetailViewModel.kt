package com.mv.coreapp.presentation.student.studentdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mv.coreapp.data.CoreResult
import com.mv.coreapp.data.repository.StudentRepository
import com.mv.coreapp.domain.model.PaymentStatus
import com.mv.coreapp.domain.model.Plan
import com.mv.coreapp.domain.model.Student
import com.mv.coreapp.domain.model.StudentStatus
import com.mv.coreapp.presentation.student.students.StudentsScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class StudentDetailViewModel @Inject constructor(
    private val studentRepository: StudentRepository
) : ViewModel() {
    private val _state = MutableStateFlow<StudentDetailState>(StudentDetailState.Loading)
    val state: StateFlow<StudentDetailState> = _state.asStateFlow()

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        _state.value = StudentDetailState.Error(exception.message ?: "Ops!")
    }

    fun loadStudent(studentId: String) {
        viewModelScope.launch(errorHandler) {
            studentRepository.getStudentById(studentId).collect { result ->
                when (result) {
                    is CoreResult.Success -> _state.value =
                        StudentDetailState.Success(result.data)
                    is CoreResult.Error -> _state.value =
                        StudentDetailState.Error(result.exception.message ?: "Ops!")
                }
            }
        }
    }
}