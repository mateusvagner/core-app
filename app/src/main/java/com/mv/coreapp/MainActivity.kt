package com.mv.coreapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mv.coreapp.designsystem.theme.CoreAppTheme
import com.mv.coreapp.navigation.Route
import com.mv.coreapp.navigation.RouteKeys
import com.mv.coreapp.presentation.student.studentdetail.StudentDetailScreen
import com.mv.coreapp.presentation.student.students.StudentsScreen
import com.mv.coreapp.presentation.student.students.StudentsScreenEventHandler
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoreAppTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier
                ) { contentPadding ->
                    AppScreen(
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
}

@Composable
fun AppScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.Students.route
    ) {
        composable(
            route = Route.Students.route
        ) {
            StudentsScreen(
                modifier = modifier,
                onEvent = { event ->
                    StudentsScreenEventHandler.handleEvent(event, navController)
                }
            )
        }

        composable(
            route = Route.StudentDetail.route,
            arguments = listOf(
                navArgument(RouteKeys.STUDENT_DETAIL_PARAM) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val studentId = backStackEntry.arguments?.getString(RouteKeys.STUDENT_DETAIL_PARAM)
            studentId?.let {
                StudentDetailScreen(studentId = studentId)
            } ?: run {
                Toast
                    .makeText(LocalContext.current, "Student Id is null", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
