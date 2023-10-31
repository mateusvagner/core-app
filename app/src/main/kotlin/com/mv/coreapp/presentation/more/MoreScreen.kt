package com.mv.coreapp.presentation.more

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.moreScreen() {
    composable(
        route = MoreFeatureRoute.More.route
    ) {
        MoreScreenContent()
    }
}