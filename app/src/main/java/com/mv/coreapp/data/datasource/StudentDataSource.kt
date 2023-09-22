package com.mv.coreapp.data.datasource

import com.mv.coreapp.network.dto.StudentDto
import kotlinx.coroutines.flow.Flow

interface StudentDataSource {

    suspend fun saveStudent(student: StudentDto)

    suspend fun getAllStudents(): List<StudentDto>

    suspend fun getAllStudentsAsFlow(): Flow<List<StudentDto>>
}
