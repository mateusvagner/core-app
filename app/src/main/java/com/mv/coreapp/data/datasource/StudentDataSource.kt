package com.mv.coreapp.data.datasource

import com.mv.coreapp.data.dto.StudentDto

interface StudentDataSource {

    suspend fun saveStudent(student: StudentDto): Boolean

    suspend fun getAllStudents(): List<StudentDto>
}