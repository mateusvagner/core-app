package com.mv.coreapp.feature.student

import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import com.mv.coreapp.domain.model.PaymentStatus
import com.mv.coreapp.domain.model.Plan
import com.mv.coreapp.domain.model.Student
import com.mv.coreapp.domain.model.StudentStatus
import com.mv.coreapp.presentation.student.uicomponents.StudentListItem
import org.junit.Rule
import org.junit.Test
import java.util.Date

class StudentTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun studentListItem_shows_all_fields() {
        // Arrange
        rule.setContent {
            StudentListItem(
                student = Student(
                    id = "",
                    name = "Mateus Vagner",
                    surname = "Guedes de Almeida",
                    birthDate = Date(),
                    enrollmentDate = Date(),
                    paymentDueDate = Date(),
                    paymentDueDay = 10,
                    modality = "Pilates",
                    plan = Plan.MONTHLY,
                    status = StudentStatus.ON_HOLD,
                    paymentStatus = PaymentStatus.PAID
                ),
                onClick = {}
            )
        }

        // Act

        // Assert
        rule.onNode(hasText("Mateus Vagner Guedes de Almeida")).assertExists()
    }


}