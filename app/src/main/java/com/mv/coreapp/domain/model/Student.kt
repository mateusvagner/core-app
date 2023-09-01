package com.mv.coreapp.domain.model

import java.util.Date

data class Student(
    var id: String,
    var name: String,
    var birthDate: String,
    var enrollmentDate: Date?,
    var paymentDueDate: Date?,
    var modality: String,
    var plan: Plan,
    var status: String,
    var paymentStatus: PaymentStatus
)
