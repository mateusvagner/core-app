package com.mv.coreapp.presentation.financial

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.mv.coreapp.navigation.Route

sealed class FinancialFeatureRoute(val route: String) {

    data object Financial : FinancialFeatureRoute("Financial")
}

fun NavGraphBuilder.financialFeature() {
    navigation(
        startDestination = Route.FinancialFeature.startDestination,
        route = Route.FinancialFeature.route
    ) {
        financialScreen()
    }
}