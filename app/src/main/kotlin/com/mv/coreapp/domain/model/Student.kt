package com.mv.coreapp.domain.model

import java.util.Date

data class Student(
    var id: String,
    var name: String,
    var surname: String,
    var birthDate: Date,
    var enrollmentDate: Date,
    var paymentDueDate: Date,
    var paymentDueDay: Int,
    var modality: String,
    var plan: Plan,
    var status: StudentStatus,
    var paymentStatus: PaymentStatus
)
