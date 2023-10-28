package com.mv.coreapp.navigation

import androidx.annotation.StringRes
import com.mv.coreapp.R

sealed class BottomNavigationItem(@StringRes val title: Int, val icon: Int, val route: Route) {
    data object Calendar : BottomNavigationItem(R.string.calendar, R.drawable.ic_calendar_month, Route.CalendarFeature)
    data object Students : BottomNavigationItem(R.string.students, R.drawable.ic_groups_2, Route.StudentsFeature)
    data object Financial : BottomNavigationItem(R.string.financial, R.drawable.ic_account_balance_wallet, Route.FinancialFeature)
    data object More : BottomNavigationItem(R.string.more, R.drawable.ic_more, Route.MoreFeature)
}

val mainNavigationItems = listOf(
    BottomNavigationItem.Calendar,
    BottomNavigationItem.Students,
    BottomNavigationItem.Financial,
    BottomNavigationItem.More
)
