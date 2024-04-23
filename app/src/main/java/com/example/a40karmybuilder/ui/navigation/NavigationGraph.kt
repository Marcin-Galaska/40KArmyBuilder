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
import com.example.a40karmybuilder.ui.AppViewModelProvider
import com.example.a40karmybuilder.ui.createdarmieslist.CreatedArmiesListDestination
import com.example.a40karmybuilder.ui.createdarmieslist.CreatedArmiesListScreen
import com.example.a40karmybuilder.ui.createdarmycomposition.CreatedArmyCompositionDestination
import com.example.a40karmybuilder.ui.createdarmycomposition.CreatedArmyCompositionScreen
import com.example.a40karmybuilder.ui.factionoverviewdetails.FactionOverviewDetailsDestination
import com.example.a40karmybuilder.ui.factionoverviewdetails.FactionOverviewDetailsScreen
import com.example.a40karmybuilder.ui.factionoverviewlist.FactionOverviewListDestination
import com.example.a40karmybuilder.ui.factionoverviewlist.FactionOverviewListScreen
import com.example.a40karmybuilder.ui.factionoverviewlist.FactionViewModel
import com.example.a40karmybuilder.ui.home.HomeDestination
import com.example.a40karmybuilder.ui.home.HomeScreen
import com.example.a40karmybuilder.ui.newarmycreator.NewArmyCreatorDestination
import com.example.a40karmybuilder.ui.newarmycreator.NewArmyCreatorScreen
import com.example.a40karmybuilder.ui.unitselection.UnitSelectionDestination
import com.example.a40karmybuilder.ui.unitselection.UnitSelectionScreen
import com.example.a40karmybuilder.ui.unitselection.UnitSelectionViewModel

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

        composable(
            route = FactionOverviewListDestination.route
        ) {
            FactionOverviewListScreen(
                navController = navController,
                navigateToFactionDetails = { navController.navigate(FactionOverviewDetailsDestination.route) }
            )
        }

        composable(
            route = FactionOverviewDetailsDestination.route
        ) {
            val viewModel: FactionViewModel = viewModel(factory = AppViewModelProvider.factory)
            val faction by viewModel.getFaction(FactionViewModel.selectedFactionId).collectAsState(null)

            faction?.let { fac ->
                FactionOverviewDetailsScreen(
                    navController = navController,
                    faction = fac,
                    navigateBack = { navController.navigateUp() }
                )
            }
        }

        composable(
            route = NewArmyCreatorDestination.route
        ) {
            NewArmyCreatorScreen(
                navController = navController,
                navigateBack = { navController.navigateUp() }
            )
        }

        composable(
            route = CreatedArmiesListDestination.route
        ) {
            CreatedArmiesListScreen(
                navController = navController,
                navigateToArmyComposition = {
                    navController.navigate("${CreatedArmyCompositionDestination.route}/${it}")
                }
            )
        }

        composable(
            route = CreatedArmyCompositionDestination.routeWithArgs,
            arguments = listOf(navArgument(CreatedArmyCompositionDestination.armyIdArg) {
                type = NavType.IntType
            })
        ) {
            CreatedArmyCompositionScreen(
                navController = navController,
                navigateBack = { navController.navigateUp() }
            )
        }

        composable(
            route = UnitSelectionDestination.route
        ) {
            val viewModel: UnitSelectionViewModel = viewModel(factory = AppViewModelProvider.factory)
            val allUnits by viewModel.getAllUnits(UnitSelectionViewModel.selectedUnitsFactionName).collectAsState(null)

            allUnits?.let { units ->
                UnitSelectionScreen(
                    navController = navController,
                    units = units,
                    navigateBack = { navController.navigateUp() }
                )
            }
        }
    }
}