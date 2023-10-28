package com.mv.coreapp.presentation.student.studentdetail

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import com.mv.coreapp.navigation.RouteKeys

@Composable
fun StudentDetailScreenStateful(
    modifier: Modifier,
    backStackEntry: NavBackStackEntry
) {
    val studentId = backStackEntry.arguments?.getString(RouteKeys.STUDENT_DETAIL_PARAM)
    studentId?.let {
        val viewModel: StudentDetailViewModel = hiltViewModel()

        StudentDetailScreenStateful(
            modifier = modifier,
            studentId = studentId,
            viewModel = viewModel
        )
    } ?: run {
        Toast.makeText(LocalContext.current, "Student Id is null", Toast.LENGTH_SHORT)
            .show()
    }
}

@Composable
private fun StudentDetailScreenStateful(
    modifier: Modifier,
    studentId: String,
    viewModel: StudentDetailViewModel
) {
    val screenState by viewModel.state.collectAsState()

    LaunchedEffect(key1 = "StudentDetailScreenStateful") {
        viewModel.loadStudent(studentId = studentId)
    }

    StudentDetailScreen(
        modifier = modifier,
        screenState = screenState,
        onEvent = { }
    )
}
