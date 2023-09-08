package com.mv.coreapp.data.datasource.remote

import com.mv.coreapp.data.datasource.StudentDataSource
import com.mv.coreapp.network.dto.StudentDto
import javax.inject.Inject

class StudentRemoteDataSource @Inject constructor(): StudentDataSource {
    override suspend fun saveStudent(student: StudentDto): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getAllStudents(): List<StudentDto> {
        TODO("Not yet implemented")
    }
}
