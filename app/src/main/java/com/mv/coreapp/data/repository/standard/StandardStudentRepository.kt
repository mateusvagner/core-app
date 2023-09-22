package com.mv.coreapp.data.repository.standard

import com.mv.coreapp.data.datasource.remote.StudentRemoteDataSource
import com.mv.coreapp.data.repository.StudentRepository
import com.mv.coreapp.domain.model.Student
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StandardStudentRepository @Inject constructor(
    private val studentDataSource: FirebaseStudentDataSource
) : StudentRepository {

    override suspend fun saveStudent(student: Student): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getAllStudents(): Flow<List<Student>> {
        TODO("Not yet implemented")
    }
}
