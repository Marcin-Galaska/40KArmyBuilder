package com.example.a40karmybuilder.ui.navigation

interface NavigationDestination {
    // Unique path name
    val route: String

    // String resource id to that contains title to be displayed for the screen
    val titleRes: Int
}