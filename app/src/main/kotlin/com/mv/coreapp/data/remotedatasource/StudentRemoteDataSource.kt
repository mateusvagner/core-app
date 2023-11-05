package com.mv.coreapp.data.remotedatasource

import com.mv.coreapp.data.remotedatasource.dto.StudentDto
import kotlinx.coroutines.flow.Flow

interface StudentRemoteDataSource {

    suspend fun saveStudent(student: StudentDto)

    suspend fun getStudentByIdAsFlow(studentId: String): Flow<StudentDto>

    suspend fun getAllStudents(): List<StudentDto>

    suspend fun getAllStudentsAsFlow(): Flow<List<StudentDto>>
}
