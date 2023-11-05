package com.mv.coreapp.data.fake

import com.mv.coreapp.data.remotedatasource.dto.StudentDto

object FakeStudentDto {

    fun makeStudentDto(): StudentDto {
        return StudentDto(
            id = "1",
            name = "John",
            surname = "Doe",
            birthDate = "1990-01-01T00:00:00.000+03:00",
            enrollmentDate = "2023-01-01T00:00:00.000+03:00",
            paymentDueDate = "2023-01-01T00:00:00.000+03:00",
            modality = "MODALITY",
            plan = "QUARTERLY",
            status = "ACTIVE",
            paymentStatus = "PAID"
        )
    }

    fun makeStudentsDto(): List<StudentDto> {
        return listOf(
            StudentDto(
                id = "1",
                name = "John",
                surname = "Doe",
                birthDate = "1990-01-01T00:00:00.000+03:00",
                enrollmentDate = "2023-01-01T00:00:00.000+03:00",
                paymentDueDate = "2023-01-01T00:00:00.000+03:00",
                modality = "MODALITY",
                plan = "QUARTERLY",
                status = "ACTIVE",
                paymentStatus = "PAID"
            ),
            StudentDto(
                id = "2",
                name = "Jane",
                surname = "Doe",
                birthDate = "1990-01-01T00:00:00.000+03:00",
                enrollmentDate = "2023-01-01T00:00:00.000+03:00",
                paymentDueDate = "2023-01-01T00:00:00.000+03:00",
                modality = "MODALITY",
                plan = "MONTHLY",
                status = "INACTIVE",
                paymentStatus = "PENDING"
            )
        )
    }
}
