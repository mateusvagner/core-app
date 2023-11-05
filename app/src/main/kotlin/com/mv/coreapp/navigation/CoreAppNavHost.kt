package com.mv.coreapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mv.coreapp.presentation.calendar.calendarFeature
import com.mv.coreapp.presentation.financial.financialFeature
import com.mv.coreapp.presentation.more.moreFeature
import com.mv.coreapp.presentation.student.studentFeature

@Composable
fun CoreAppNavHost(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.StudentsFeature.route
    ) {
        calendarFeature()

        studentFeature(
            modifier = modifier,
            navController = navController
        )

        financialFeature()

        moreFeature()
    }
}
