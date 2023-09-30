package com.mv.coreapp.presentation.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mv.coreapp.designsystem.theme.CoreAppTheme

@Composable
fun CoreAppBottomNavigation(selectedScreen: String, onClick: (String) -> Unit) {
    val items = listOf(
        BottomNavigationItem.Calendar,
        BottomNavigationItem.Students,
        BottomNavigationItem.Financial,
        BottomNavigationItem.More
    )

    NavigationBar(
        modifier = Modifier
            .padding(horizontal = 8.dp).padding(bottom = 8.dp)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp))
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = stringResource(id = item.title)
                    )
                },
                label = { Text(stringResource(item.title)) },
                selected = item.screenRoute == selectedScreen,
                onClick = {
                    onClick(item.screenRoute)
                }
            )
        }
    }
}

@Composable
@Preview
fun CoreAppBottomNavigationPreview() {
    CoreAppTheme {
        CoreAppBottomNavigation(
            selectedScreen = BottomNavigationItem.Students.screenRoute,
            onClick = {}
        )
    }
}