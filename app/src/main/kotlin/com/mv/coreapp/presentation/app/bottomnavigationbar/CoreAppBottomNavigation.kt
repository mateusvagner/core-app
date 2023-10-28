package com.mv.coreapp.presentation.app.bottomNavigationBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mv.coreapp.designsystem.theme.CoreAppTheme
import com.mv.coreapp.designsystem.theme.light_primarySurface

@Composable
fun CoreAppBottomNavigation(currentRoute: String, onClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .padding(bottom = 8.dp)
            .background(
                color = light_primarySurface,
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            mainNavigationItems.forEach { navigationItem ->
                CoreAppNavigationItem(
                    modifier = Modifier.padding(8.dp),
                    item = navigationItem,
                    selected = navigationItem.route.startDestination == currentRoute,
                    onClick = {
                        onClick(navigationItem.route.route)
                    }
                )
            }
        }
    }
}

@Composable
@Preview
fun CoreAppBottomNavigationCalendarPreview() {
    CoreAppTheme {
        CoreAppBottomNavigation(
            currentRoute = BottomNavigationItem.Calendar.route.startDestination,
            onClick = {}
        )
    }
}

@Composable
@Preview
fun CoreAppBottomNavigationStudentPreview() {
    CoreAppTheme {
        CoreAppBottomNavigation(
            currentRoute = BottomNavigationItem.Students.route.startDestination,
            onClick = {}
        )
    }
}
