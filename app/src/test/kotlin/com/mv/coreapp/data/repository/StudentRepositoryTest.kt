package com.mv.coreapp.data.repository

import com.mv.coreapp.data.fake.FakeStudentDto
import com.mv.coreapp.data.fake.FakeStudentRemoteDataSource
import com.mv.coreapp.data.mapper.StudentMapper
import com.mv.coreapp.data.repository.impl.StudentRepositoryImpl
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class StudentRepositoryTest {

    private val studentRemoteDataSource = FakeStudentRemoteDataSource()

    private lateinit var studentRepository: StudentRepositoryImpl

    @Before
    fun setUp() {
        studentRepository = StudentRepositoryImpl(studentRemoteDataSource)
    }

    @Test
    fun `saveStudent should return true when student is saved successfully`() = runTest {
        // Arrange
        val studentDto = FakeStudentDto.makeStudentDto()

        // Act
        val result = studentRepository.saveStudent(
            student = StudentMapper.mapStudentDtoToStudent(studentDto)
        )

        // Assert
        Assert.assertTrue(result)
    }

    @Test
    fun `saveStudent should return false when student is not saved successfully`() = runTest {
        // Arrange
        val studentDto = FakeStudentDto.makeStudentDto()

        val exception = Exception()
        studentRemoteDataSource.setError(exception)

        // Act
        val result = studentRepository.saveStudent(
            student = StudentMapper.mapStudentDtoToStudent(studentDto)
        )

        // Assert
        Assert.assertFalse(result)
    }
}