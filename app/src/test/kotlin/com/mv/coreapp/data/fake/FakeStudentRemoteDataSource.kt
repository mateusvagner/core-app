package com.mv.coreapp.data.fake

import com.mv.coreapp.data.remotedatasource.StudentRemoteDataSource
import com.mv.coreapp.data.remotedatasource.dto.StudentDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeStudentRemoteDataSource : StudentRemoteDataSource {

    private var studentDto: StudentDto? = null
    private var studentsDto: List<StudentDto>? = null
    private var error: Exception? = null

    fun setStudentDto(studentDto: StudentDto) {
        this.studentDto = studentDto
        this.error = null
    }

    fun setStudentsDto(studentsDto: List<StudentDto>) {
        this.studentsDto = studentsDto
        this.error = null
    }

    fun setError(error: Exception) {
        this.error = error
        this.studentDto = null
        this.studentsDto = null
    }

    override suspend fun saveStudent(student: StudentDto) {
        if (error != null) {
            throw error!!
        }
    }

    override suspend fun getStudentById(studentId: String): StudentDto {
        if (error != null) {
            throw error!!
        } else {
            return studentDto!!
        }
    }

    override suspend fun getStudentByIdAsFlow(studentId: String): Flow<StudentDto> = flow {
        if (error != null) {
            throw error!!
        } else {
            emit(studentDto!!)
        }
    }

    override suspend fun getAllStudents(): List<StudentDto> {
        if (error != null) {
            throw error!!
        } else {
            return studentsDto!!
        }
    }

    override suspend fun getAllStudentsAsFlow(): Flow<List<StudentDto>> = flow {
        if (error != null) {
            throw error!!
        } else {
            emit(studentsDto!!)
        }
    }
}
