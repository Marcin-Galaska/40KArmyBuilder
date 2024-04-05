package com.example.a40karmybuilder.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.a40karmybuilder.ui.factionoverviewlist.FactionOverviewListDestination
import com.example.a40karmybuilder.ui.factionoverviewlist.FactionOverviewListScreen
import com.example.a40karmybuilder.ui.home.HomeDestination
import com.example.a40karmybuilder.ui.home.HomeScreen

@Composable
fun a40KArmyBuilderNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(
            route = HomeDestination.route
        ) {
            HomeScreen(
                navigateToFactionOverviewList = { navController.navigate(FactionOverviewListDestination.route) }
            )
        }
//        composable(route = ItemEntryDestination.route) {
//            ItemEntryScreen(
//                navigateBack = { navController.popBackStack() },
//                onNavigateUp = { navController.navigateUp() }
//            )
//        }
        composable(
            route = FactionOverviewListDestination.route
        ) {
            FactionOverviewListScreen(
//                navigateToEditItem = { navController.navigate("${FactionOverviewListDestination.route}/$it") },
//                navigateBack = { navController.navigateUp() }
                navigateToCreatedArmiesList = {},
                navigateToFactionOverview = {}
            )
        }
//        composable(
//            route = ItemEditDestination.routeWithArgs,
//            arguments = listOf(navArgument(ItemEditDestination.itemIdArg) {
//                type = NavType.IntType
//            })
//        ) {
//            ItemEditScreen(
//                navigateBack = { navController.popBackStack() },
//                onNavigateUp = { navController.navigateUp() }
//            )
//        }
    }
}