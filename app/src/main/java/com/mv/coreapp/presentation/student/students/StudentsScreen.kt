package com.mv.coreapp.presentation.student.students

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mv.coreapp.designsystem.theme.CoreAppTheme
import com.mv.coreapp.domain.model.PaymentStatus
import com.mv.coreapp.domain.model.Plan
import com.mv.coreapp.domain.model.Student
import com.mv.coreapp.domain.model.StudentStatus
import com.mv.coreapp.presentation.student.components.StudentListItem
import java.util.Date

@Composable
fun StudentsScreen(
    modifier: Modifier = Modifier,
    screenState: StudentsScreenState,
    onEvent: (StudentsScreenEvent) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            onEvent(StudentsScreenEvent.StudentClicked(studentId = "id_1"))
        }) {
            Text(text = "Add Fake Student")
        }
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
                StudentsScreenSuccess(
                    modifier = modifier,
                    students = screenState.students,
                    onEvent = onEvent
                )
            }
        }
    }

}

@Composable
private fun StudentsScreenSuccess(
    modifier: Modifier,
    students: List<Student>,
    onEvent: (StudentsScreenEvent) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(students) { student ->
            StudentListItem(student = student, onClick = {
                onEvent(
                    StudentsScreenEvent.StudentClicked(
                        studentId = student.id
                    )
                )
            })
        }
    }
}

@Composable
@Preview
fun StudentsScreenPreview() {
    CoreAppTheme {
        StudentsScreen(
            modifier = Modifier.padding(16.dp),
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
