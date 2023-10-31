package com.mv.coreapp.presentation.financial

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.financialScreen() {
    composable(
        route = FinancialFeatureRoute.Financial.route
    ) {
        FinancialScreenContent()
    }
}
