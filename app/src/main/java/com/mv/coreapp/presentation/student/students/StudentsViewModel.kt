package com.mv.coreapp.presentation.student.students

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mv.coreapp.data.CoreResult
import com.mv.coreapp.data.repository.StudentRepository
import com.mv.coreapp.domain.model.Student
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentsViewModel @Inject constructor(
    private val studentRepository: StudentRepository
) : ViewModel() {

    private val _state = MutableStateFlow<StudentsScreenState>(StudentsScreenState.Loading)
    val state: StateFlow<StudentsScreenState> = _state.asStateFlow()

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        _state.value = StudentsScreenState.Error(exception.message ?: "Ops!")
    }

    init {
        loadStudents()
    }

    private fun loadStudents() {
        viewModelScope.launch(errorHandler) {
            studentRepository.getAllStudents().collect { result ->
                when (result) {
                    is CoreResult.Success -> handleSuccess(result)
                    is CoreResult.Error -> _state.value =
                        StudentsScreenState.Error(result.exception.message ?: "Ops!")
                }
            }
        }
    }

    private fun handleSuccess(result: CoreResult.Success<List<Student>>) {
        if (result.data.isEmpty()) {
            _state.value = StudentsScreenState.Empty
        } else {
            _state.value = StudentsScreenState.Success(result.data)
        }
    }
}
