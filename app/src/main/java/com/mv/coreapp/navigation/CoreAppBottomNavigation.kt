package com.mv.coreapp.navigation

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
fun CoreAppBottomNavigation(currentRoute: String, onClick: (String) -> Unit) {
    NavigationBar(
        modifier = Modifier
            .padding(horizontal = 8.dp).padding(bottom = 8.dp)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp))
    ) {
        mainNavigationItems.forEach { navigationItem ->
            NavigationBarItem(
                icon = {
                    Image(
                        painter = painterResource(id = navigationItem.icon),
                        contentDescription = stringResource(id = navigationItem.title)
                    )
                },
                label = { Text(stringResource(navigationItem.title)) },
                selected = navigationItem.route.value == currentRoute,
                onClick = {
                    onClick(navigationItem.route.value)
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
            currentRoute = BottomNavigationItem.Students.route.value,
            onClick = {}
        )
    }
}
