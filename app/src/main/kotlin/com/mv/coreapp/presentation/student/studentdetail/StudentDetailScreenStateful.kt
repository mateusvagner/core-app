package com.mv.coreapp.presentation.student.studentdetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun StudentDetailScreenStateful(
    modifier: Modifier
) {
    val viewModel: StudentDetailViewModel = hiltViewModel()

    StudentDetailScreenStateful(
        modifier = modifier,
        viewModel = viewModel
    )
}

@Composable
private fun StudentDetailScreenStateful(
    modifier: Modifier,
    viewModel: StudentDetailViewModel
) {
    val screenState by viewModel.state.collectAsState()

    StudentDetailScreen(
        modifier = modifier,
        screenState = screenState,
        onEvent = { }
    )
}
