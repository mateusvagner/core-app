package com.mv.coreapp.data.repository

import com.mv.coreapp.data.CoreResult
import com.mv.coreapp.domain.model.Student
import kotlinx.coroutines.flow.Flow

interface StudentRepository {

    suspend fun saveStudent(student: Student): Boolean

    suspend fun getStudentById(studentId: String): Flow<CoreResult<Student>>

    suspend fun getAllStudents(): Flow<CoreResult<List<Student>>>
}
