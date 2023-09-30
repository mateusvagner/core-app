package com.mv.coreapp.presentation.student.studentdetail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mv.coreapp.designsystem.theme.CoreAppTheme
import com.mv.coreapp.domain.model.PaymentStatus
import com.mv.coreapp.domain.model.Plan
import com.mv.coreapp.domain.model.Student
import com.mv.coreapp.domain.model.StudentStatus
import java.util.Date

@Composable
fun StudentDetailScreen(
    modifier: Modifier = Modifier,
    screenState: StudentDetailState,
    onEvent: (StudentDetailEvent) -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (screenState) {
            is StudentDetailState.Loading -> {
                Text(text = "Loading")
                onEvent(StudentDetailEvent.StudentLoad)
            }

            is StudentDetailState.Error -> {
                Text(text = screenState.message)
            }

            is StudentDetailState.Success -> {
                Text(text = "Students id: ${screenState.student.name}")
            }
        }
    }
}

@Composable
@Preview
private fun StudentDetailScreenPreview() {
    CoreAppTheme {
        StudentDetailScreen(
            screenState = StudentDetailState.Success(
                Student(
                    id = "id_1",
                    name = "Mateus Vagner",
                    surname = "Guedes de Almeida",
                    birthDate = Date(),
                    enrollmentDate = Date(),
                    paymentDueDate = Date(),
                    modality = "Pilates",
                    plan = Plan.MONTHLY,
                    status = StudentStatus.ON_HOLD,
                    paymentStatus = PaymentStatus.PAID
                )
            )
        )
    }
}
