package com.mv.coreapp.data.dto

data class StudentDto(
    var id: String,
    var name: String,
    var birthDate: String,
    var enrollmentDate: String,
    var paymentDueDate: String,
    var modality: String,
    var plan: String,
    var status: String,
    var paymentStatus: String
)
