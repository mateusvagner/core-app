package com.mv.coreapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mv.coreapp.designsystem.theme.CoreAppTheme
import com.mv.coreapp.navigation.CoreAppNavHost
import com.mv.coreapp.navigation.Route
import com.mv.coreapp.presentation.app.bottomnavigationbar.AnimatedBottomNavigation
import com.mv.coreapp.presentation.app.bottomnavigationbar.CoreAppBottomNavigation
import com.mv.coreapp.presentation.app.bottomnavigationbar.model.mainNavigationItems
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoreAppTheme {
                val navController = rememberNavController()

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route ?: Route.StudentsFeature.route

                Scaffold(
                    modifier = Modifier,
                    bottomBar = {
                        MainBottomNavigation(
                            currentRoute = currentRoute,
                            navController = navController,
                        )
                    }
                ) { contentPadding ->
                    CoreAppNavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colorScheme.background)
                            .padding(contentPadding),
                        navController = navController
                    )
                }
            }
        }
    }

    @Composable
    private fun MainBottomNavigation(
        currentRoute: String,
        navController: NavHostController,
    ) {
        val isBottomNavigationVisible = mainNavigationItems.any {
            it.route.startDestination == currentRoute || it.route.route == currentRoute
        }

        AnimatedBottomNavigation(
            isVisible = isBottomNavigationVisible
        ) {
            CoreAppBottomNavigation(currentRoute = currentRoute) { route ->
                navController.navigate(route) {
                    navController.currentBackStackEntry?.destination?.route?.let { screenRoute ->
                        popUpTo(screenRoute) {
                            inclusive = true
                        }
                    }
                }
            }
        }
    }
}
