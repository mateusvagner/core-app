package com.mv.coreapp.network.dto

data class StudentDto(
    var id: String,
    var name: String,
    var surname: String,
    var birthDate: String,
    var enrollmentDate: String,
    var paymentDueDate: String,
    var modality: String,
    var plan: String,
    var status: String,
    var paymentStatus: String
)
