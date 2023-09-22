package com.mv.coreapp.data.remotedatasource

import com.mv.coreapp.data.remotedatasource.dto.StudentDto
import kotlinx.coroutines.flow.Flow

interface RemoteStudentDataSource {

    suspend fun saveStudent(student: StudentDto)

    suspend fun getAllStudents(): List<StudentDto>

    suspend fun getAllStudentsAsFlow(): Flow<List<StudentDto>>
}
