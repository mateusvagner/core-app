package com.mv.coreapp.presentation.student.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mv.coreapp.designsystem.theme.CoreAppTheme
import com.mv.coreapp.designsystem.theme.primaryVariation
import com.mv.coreapp.domain.model.PaymentStatus
import com.mv.coreapp.domain.model.Plan
import com.mv.coreapp.domain.model.Student
import com.mv.coreapp.domain.model.StudentStatus
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentListItem(
    modifier: Modifier = Modifier,
    student: Student,
    onClick: (Student) -> Unit
) {
    ElevatedCard(
        modifier = modifier.clip(RoundedCornerShape(4.dp)),
        shape = RoundedCornerShape(4.dp),
        onClick = { onClick(student) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(0.90f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        append(student.name)
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.secondary,
                                fontSize = 14.sp
                            )
                        ) {
                            append(" " + student.surname)
                        }
                    },
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary

                )

                Text(text = "Nascimento: ${student.birthDate}", fontSize = 14.sp)
                Text(text = "Plano: ${student.plan}", fontSize = 14.sp)
            }

            Column(
                modifier = Modifier.weight(0.10f),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                StudentStatusIndicator(student.status)
                PaymentStatusIndicator(status = student.paymentStatus)
            }
        }
    }
}

@Composable
private fun StudentStatusIndicator(status: StudentStatus) {
    Surface(
        modifier = Modifier.size(24.dp),
        shape = CircleShape,
        color = when (status) {
            StudentStatus.ACTIVE -> Color.Green
            StudentStatus.INACTIVE -> MaterialTheme.colorScheme.error
            StudentStatus.ON_HOLD -> Color.Yellow
        }
    ) {
    }
}

@Composable
fun PaymentStatusIndicator(status: PaymentStatus) {
    when (status) {
        PaymentStatus.PAID -> Icon(
            modifier = Modifier.size(size = 24.dp),
            imageVector = Icons.Default.CheckCircle,
            contentDescription = status.name,
            tint = primaryVariation
        )

        PaymentStatus.PENDING -> Icon(
            modifier = Modifier.size(size = 24.dp),
            imageVector = Icons.Default.Warning,
            contentDescription = status.name,
            tint = MaterialTheme.colorScheme.error
        )
    }
}

@Composable
@Preview
fun StudentListItemPreview() {
    CoreAppTheme {
        StudentListItem(
            modifier = Modifier.padding(8.dp),
            student = Student(
                id = "",
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
            onClick = {}
        )
    }
}
