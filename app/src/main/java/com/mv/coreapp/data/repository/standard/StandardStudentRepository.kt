package com.mv.coreapp.data.repository.standard

import com.mv.coreapp.data.CoreResult
import com.mv.coreapp.data.remotedatasource.firebaseimpl.FirebaseRemoteStudentDataSource
import com.mv.coreapp.data.mapper.StudentMapper
import com.mv.coreapp.data.repository.StudentRepository
import com.mv.coreapp.domain.model.Student
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StandardStudentRepository @Inject constructor(
    private val studentDataSource: FirebaseRemoteStudentDataSource
) : StudentRepository {

    override suspend fun saveStudent(student: Student): Boolean {
        return try {
            val studentDto = StudentMapper.mapStudentToStudentDto(student)
            studentDataSource.saveStudent(studentDto)
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun getAllStudents(): Flow<CoreResult<List<Student>>> {
        return studentDataSource.getAllStudentsAsFlow()
            .map { studentsDto ->
                CoreResult.Success(studentsDto.map(StudentMapper::mapStudentDtoToStudent))
            }.catch { throwable ->
                val exception = Exception(throwable)
                CoreResult.Error(exception)
            }
    }
}
