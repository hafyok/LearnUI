package com.example.learnui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import com.example.learnui.data.BottomNavigation

val items = listOf(
    BottomNavigation(
        title = "Home",
        icon = Icons.Rounded.Home
    ),

    BottomNavigation(
        title = "Wallet",
        icon = Icons.Rounded.Wallet
    ),

    BottomNavigation(
        title = "Notification",
        icon = Icons.Rounded.Notifications
    ),

    BottomNavigation(
        title = "Account",
        icon = Icons.Rounded.AccountCircle
    )

)