package com.example.a40karmybuilder.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.a40karmybuilder.ui.factionoverviewdetails.FactionOverviewDetailsDestination
import com.example.a40karmybuilder.ui.factionoverviewdetails.FactionOverviewDetailsScreen
import com.example.a40karmybuilder.ui.factionoverviewlist.FactionOverviewListDestination
import com.example.a40karmybuilder.ui.factionoverviewlist.FactionOverviewListScreen
import com.example.a40karmybuilder.ui.factionoverviewlist.FactionViewModel
import com.example.a40karmybuilder.ui.home.HomeDestination
import com.example.a40karmybuilder.ui.home.HomeScreen

@Composable
fun a40KArmyBuilderNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = FactionOverviewDetailsDestination.route,
        modifier = modifier
    ) {
        // Home screen
        composable(
            route = HomeDestination.route
        ) {
            HomeScreen(
                navigateToFactionOverviewList = { navController.navigate(FactionOverviewListDestination.route) }
            )
        }

        // Faction Overview List screen
        composable(
            route = FactionOverviewListDestination.route
        ) {
            FactionOverviewListScreen(
                navigateToFactionDetails = { navController.navigate(FactionOverviewDetailsDestination.route) }
            )
        }

        // Faction Overview Details screen
        composable(
            //route = FactionOverviewDetailsDestination.route
            route = FactionOverviewDetailsDestination.route
        ) {
            val viewModel: FactionViewModel = viewModel(factory = FactionViewModel.factory)
            val faction by viewModel.getFaction(id = 3).collectAsState(null)

            faction?.let { fac ->
                FactionOverviewDetailsScreen(
                    faction = fac,
                    navigateBack = { navController.navigateUp() }
                )
            }
        }

//        composable(
//            route = FactionOverviewDetailsDestination.routeWithArgs,
//            arguments = listOf(navArgument(FactionOverviewDetailsDestination.factionNameArg) {
//                type = NavType.StringType
//            })
//        ) {
//            FactionOverviewDetailsScreen(
//                factionName = it,
//                navigateBack = { navController.navigateUp() }
//            )
//        }
    }
}