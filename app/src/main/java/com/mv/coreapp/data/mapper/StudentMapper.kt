package com.mv.coreapp.data.mapper

import com.mv.coreapp.data.dto.StudentDto
import com.mv.coreapp.domain.model.PaymentStatus
import com.mv.coreapp.domain.model.Plan
import com.mv.coreapp.domain.model.Student
import com.mv.coreapp.util.DateParser

object StudentMapper {
    fun mapStudentDtoToStudent(dto: StudentDto): Student{
        return Student(
            id = dto.id,
            name = dto.name,
            birthDate = dto.birthDate,
            enrollmentDate = DateParser.parseDate(dto.enrollmentDate),
            paymentDueDate = DateParser.parseDate(dto.paymentDueDate),
            modality = dto.modality,
            plan = Plan.valueOf(dto.plan),
            status = dto.status,
            paymentStatus = PaymentStatus.valueOf(dto.paymentStatus)
        )
    }

    fun mapStudentToStudentDto(student: Student): StudentDto {
        if (student.enrollmentDate == null || student.paymentDueDate == null) {
            throw IllegalArgumentException("Student enrollmentDate or paymentDueDate is null")
        }

        return StudentDto(
            id = student.id,
            name = student.name,
            birthDate = student.birthDate,
            enrollmentDate = DateParser.formatDate(student.enrollmentDate!!),
            paymentDueDate = DateParser.formatDate(student.paymentDueDate!!),
            modality = student.modality,
            plan = student.plan.name,
            status = student.status,
            paymentStatus = student.paymentStatus.name
        )
    }
}
