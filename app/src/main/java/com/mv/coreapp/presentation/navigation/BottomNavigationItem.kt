package com.mv.coreapp.presentation.navigation

import androidx.annotation.StringRes
import com.mv.coreapp.R
import com.mv.coreapp.navigation.Route

sealed class BottomNavigationItem(@StringRes val title: Int, val icon: Int, val screenRoute: String) {
    data object Calendar : BottomNavigationItem(R.string.calendar, R.drawable.ic_calendar_month, Route.Calendar.route)
    data object Students : BottomNavigationItem(R.string.students, R.drawable.ic_groups_2, Route.Students.route)
    data object Financial : BottomNavigationItem(R.string.financial, R.drawable.ic_account_balance_wallet, Route.Financial.route)
    data object More : BottomNavigationItem(R.string.more, R.drawable.ic_more, Route.More.route)
}
