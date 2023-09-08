package com.mv.coreapp.data.datasource

import com.mv.coreapp.network.dto.StudentDto

interface StudentDataSource {

    suspend fun saveStudent(student: StudentDto): Boolean

    suspend fun getAllStudents(): List<StudentDto>
}