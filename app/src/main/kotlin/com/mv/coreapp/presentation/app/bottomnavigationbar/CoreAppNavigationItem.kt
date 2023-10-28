package com.mv.coreapp.presentation.app.bottomNavigationBar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mv.coreapp.designsystem.theme.CoreAppTheme
import com.mv.coreapp.presentation.app.bottomnavigationbar.model.BottomNavigationItem

@Composable
fun CoreAppNavigationItem(
    modifier: Modifier = Modifier,
    item: BottomNavigationItem,
    selected: Boolean = false,
    onClick: () -> Unit = {}
) {
    val background =
        if (selected) {
            MaterialTheme.colorScheme.surface
        } else {
            Color.Transparent
        }

    val contentColor =
        if (selected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = stringResource(id = item.title),
                tint = contentColor
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = stringResource(id = item.title),
                    color = contentColor,
                    maxLines = 1
                )
            }
        }
    }
}

@Composable
@Preview
fun CoreAppNavigationBarItemSelectedPreview() {
    CoreAppTheme {
        CoreAppNavigationItem(
            modifier = Modifier.padding(8.dp),
            item = BottomNavigationItem.Calendar,
            selected = true,
            onClick = {}
        )
    }
}

@Composable
@Preview
fun CoreAppNavigationBarItemUnselectedPreview() {
    CoreAppTheme {
        CoreAppNavigationItem(
            modifier = Modifier.padding(8.dp),
            item = BottomNavigationItem.Calendar,
            selected = false,
            onClick = {}
        )
    }
}
