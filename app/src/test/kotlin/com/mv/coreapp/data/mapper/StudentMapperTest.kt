package com.mv.coreapp.data.mapper

import com.mv.coreapp.data.fake.FakeStudentDto
import com.mv.coreapp.domain.model.PaymentStatus
import com.mv.coreapp.domain.model.Plan
import com.mv.coreapp.domain.model.StudentStatus
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class StudentMapperTest {

    @Test
    fun `mapStudentDtoToStudent should return a Student`() {
        // Arrange
        val studentDto = FakeStudentDto.makeStudentDto()

        // Act
        val student = StudentMapper.mapStudentDtoToStudent(studentDto)

        // Assert
        assertTrue(student.id == studentDto.id)
        assertTrue(student.name == studentDto.name)
        assertTrue(student.surname == studentDto.surname)
        assertTrue(student.paymentDueDay == studentDto.paymentDueDay)
        assertTrue(student.modality == studentDto.modality)

        assertEquals(Plan.QUARTERLY, student.plan)
        assertEquals(StudentStatus.ACTIVE, student.status)
        assertEquals(PaymentStatus.PAID, student.paymentStatus)
    }
}