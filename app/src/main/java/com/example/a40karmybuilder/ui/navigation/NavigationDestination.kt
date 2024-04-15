package com.example.a40karmybuilder.ui.navigation

interface NavigationDestination {
    val route: String       // Unique path name
    val titleRes: Int       // String resource id to that contains title to be displayed for the screen
}