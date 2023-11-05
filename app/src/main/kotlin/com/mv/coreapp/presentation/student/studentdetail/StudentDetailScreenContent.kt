package com.mv.coreapp.presentation.student.studentdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mv.coreapp.designsystem.components.BackButtonScreenContainer
import com.mv.coreapp.designsystem.components.baseHorizontalPadding
import com.mv.coreapp.designsystem.theme.CoreAppTheme
import com.mv.coreapp.domain.model.PaymentStatus
import com.mv.coreapp.domain.model.Plan
import com.mv.coreapp.domain.model.Student
import com.mv.coreapp.domain.model.StudentStatus
import java.util.Date

@Composable
fun StudentDetailScreenContent(
    modifier: Modifier = Modifier,
    screenState: StudentDetailState,
    onEvent: (StudentDetailEvent) -> Unit = {}
) {
    BackButtonScreenContainer(
        modifier = modifier,
        onBackPressed = { onEvent(StudentDetailEvent.BackPressed) }
    ) {
        when (screenState) {
            is StudentDetailState.Loading -> {
                Text(text = "Loading")
            }

            is StudentDetailState.Error -> {
                Text(text = screenState.message)
            }

            is StudentDetailState.Success -> {
                StudentDetailScreenContentSuccess(student = screenState.student)
            }
        }
    }
}

@Composable
fun StudentDetailScreenContentSuccess(
    student: Student,
) {
    Column(
        modifier = Modifier.baseHorizontalPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = student.name, style = MaterialTheme.typography.titleLarge)
        Text(
            text = student.surname,
            style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.secondary)
        )
    }
}

@Composable
@Preview
private fun StudentDetailScreenContentPreview() {
    CoreAppTheme {
        StudentDetailScreenContent(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.surface),
            screenState = StudentDetailState.Success(
                Student(
                    id = "id_1",
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
                )
            )
        )
    }
}
