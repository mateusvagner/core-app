package com.mv.coreapp.presentation.more

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.mv.coreapp.navigation.Route

sealed class MoreFeatureRoute(val route: String) {

    data object More : MoreFeatureRoute("More")
}

fun NavGraphBuilder.moreFeature() {
    navigation(
        startDestination = Route.MoreFeature.startDestination,
        route = Route.MoreFeature.route
    ) {
        moreScreen()
    }
}