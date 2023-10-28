package com.mv.coreapp.presentation.app.bottomnavigationbar.model

import androidx.annotation.StringRes
import com.mv.coreapp.R
import com.mv.coreapp.navigation.Route

sealed class BottomNavigationItem(@StringRes val title: Int, val icon: Int, val route: Route) {
    data object Calendar : BottomNavigationItem(
        title = R.string.calendar,
        icon = R.drawable.ic_calendar_month,
        route = Route.CalendarFeature
    )

    data object Students : BottomNavigationItem(
        title = R.string.students,
        icon = R.drawable.ic_groups_2,
        route = Route.StudentsFeature
    )

    data object Financial : BottomNavigationItem(
        title = R.string.financial,
        icon = R.drawable.ic_account_balance_wallet,
        route = Route.FinancialFeature
    )

    data object More : BottomNavigationItem(
        title = R.string.more,
        icon = R.drawable.ic_more,
        route = Route.MoreFeature
    )
}

val mainNavigationItems = listOf(
    BottomNavigationItem.Calendar,
    BottomNavigationItem.Students,
    BottomNavigationItem.Financial,
    BottomNavigationItem.More
)
