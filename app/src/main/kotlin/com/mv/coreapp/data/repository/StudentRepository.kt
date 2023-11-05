package com.mv.coreapp.data.repository

import com.mv.coreapp.data.CoreResult
import com.mv.coreapp.domain.model.Student
import kotlinx.coroutines.flow.Flow

interface StudentRepository {

    suspend fun saveStudent(student: Student): Boolean

    suspend fun getStudentByIdAsFlow(studentId: String): Flow<CoreResult<Student>>

    suspend fun getAllStudentsAsFlow(): Flow<CoreResult<List<Student>>>
}
