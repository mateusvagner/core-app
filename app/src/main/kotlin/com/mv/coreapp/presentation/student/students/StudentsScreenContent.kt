package com.mv.coreapp.presentation.student.students

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mv.coreapp.designsystem.components.basePadding
import com.mv.coreapp.designsystem.theme.CoreAppTheme
import com.mv.coreapp.domain.model.PaymentStatus
import com.mv.coreapp.domain.model.Plan
import com.mv.coreapp.domain.model.Student
import com.mv.coreapp.domain.model.StudentStatus
import com.mv.coreapp.presentation.student.uicomponents.StudentListItem
import java.util.Date

@Composable
fun StudentsScreenContent(
    modifier: Modifier = Modifier,
    screenState: StudentsScreenState,
    onEvent: (StudentsScreenEvent) -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (screenState) {
            is StudentsScreenState.Loading -> {
                Text(text = "Loading")
            }

            is StudentsScreenState.Error -> {
                Text(text = screenState.message)
            }

            is StudentsScreenState.Empty -> {
                Text(text = "Empty")
            }

            is StudentsScreenState.Success -> {
                StudentsScreenContentSuccess(
                    students = screenState.students,
                    onEvent = onEvent
                )
            }
        }
    }
}

@Composable
private fun StudentsScreenContentSuccess(
    modifier: Modifier = Modifier,
    students: List<Student>,
    onEvent: (StudentsScreenEvent) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .basePadding()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(students) { student ->
            StudentListItem(student = student, onClick = {
                onEvent(
                    StudentsScreenEvent.StudentPressed(
                        studentId = student.id
                    )
                )
            })
        }
    }
}

@Composable
@Preview
private fun StudentsScreenContentPreview() {
    CoreAppTheme {
        StudentsScreenContent(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.surface),
            screenState = StudentsScreenState.Success(
                students = listOf(
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
                    ),
                    Student(
                        id = "id_2",
                        name = "Rosiane",
                        surname = "Guedes de Almeida",
                        birthDate = Date(),
                        enrollmentDate = Date(),
                        paymentDueDate = Date(),
                        modality = "Musculação",
                        plan = Plan.MONTHLY,
                        status = StudentStatus.ACTIVE,
                        paymentStatus = PaymentStatus.PENDING
                    )
                )
            )
        )
    }
}
