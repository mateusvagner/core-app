package com.mv.coreapp.data.mapper

import com.mv.coreapp.data.remotedatasource.dto.StudentDto
import com.mv.coreapp.domain.model.PaymentStatus
import com.mv.coreapp.domain.model.Plan
import com.mv.coreapp.domain.model.Student
import com.mv.coreapp.domain.model.StudentStatus
import com.mv.coreapp.util.DateParser

object StudentMapper {
    fun mapStudentDtoToStudent(dto: StudentDto): Student {
        return Student(
            id = dto.id!!,
            name = dto.name!!,
            surname = dto.surname!!,
            birthDate = DateParser.parseDateIsoFormat(dto.birthDate!!)!!, // TODO Fallback for parse error
            enrollmentDate = DateParser.parseDateIsoFormat(dto.enrollmentDate!!)!!, // TODO Fallback for parse error
            paymentDueDate = DateParser.parseDateIsoFormat(dto.paymentDueDate!!)!!, // TODO Fallback for parse error
            paymentDueDay = dto.paymentDueDay!!,
            modality = dto.modality!!,
            plan = Plan.valueOf(dto.plan!!),
            status = StudentStatus.valueOf(dto.status!!),
            paymentStatus = PaymentStatus.valueOf(dto.paymentStatus!!)
        )
    }

    fun mapStudentToStudentDto(student: Student): StudentDto {
        return StudentDto(
            id = student.id,
            name = student.name,
            surname = student.surname,
            birthDate = DateParser.formatDateIsoFormat(student.birthDate),
            enrollmentDate = DateParser.formatDateIsoFormat(student.enrollmentDate),
            paymentDueDate = DateParser.formatDateIsoFormat(student.paymentDueDate),
            modality = student.modality,
            plan = student.plan.name,
            status = student.status.name,
            paymentStatus = student.paymentStatus.name
        )
    }
}
