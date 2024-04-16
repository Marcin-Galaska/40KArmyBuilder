package com.example.a40karmybuilder.ui.newarmy

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.a40karmybuilder.R
import com.example.a40karmybuilder.a40KArmyBuilderBottomAppBar
import com.example.a40karmybuilder.a40KArmyBuilderTopAppBar
import com.example.a40karmybuilder.data.Faction
import com.example.a40karmybuilder.ui.factionoverviewlist.FactionViewModel
import com.example.a40karmybuilder.ui.navigation.NavigationDestination
import kotlinx.coroutines.flow.first

object NewArmySelectionDestination : NavigationDestination {
    override val route = "new_army_selection"
    override val titleRes = R.string.new_army_selection_top_bar_text
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewArmySelectionScreen(
    navController: NavHostController,
    navigateToNewArmyDetails: () -> Unit,
    navigateBack: () -> Unit,
    viewModel: FactionViewModel = viewModel(factory = FactionViewModel.factory),
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    var allFactions by remember { mutableStateOf(emptyList<Faction>()) }

    LaunchedEffect(viewModel) {
        allFactions = viewModel.getAllFactions().first()
    }

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            a40KArmyBuilderTopAppBar(
                title = stringResource(NewArmySelectionDestination.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack,
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            a40KArmyBuilderBottomAppBar(
                navController = navController
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = innerPadding
        ) {
            items(allFactions) {
                NewArmyFactionCard(
                    faction = it,
                    onClick = navigateToNewArmyDetails,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_tiny))
                )
            }
        }
    }
}

@SuppressLint("DiscouragedApi")
@Composable
private fun NewArmyFactionCard(
    faction: Faction,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val symbolResourceId = context.resources.getIdentifier(
        faction.drawablePrefix + "_symbol",
        "drawable",
        context.packageName
    )

    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.unit_card_black)
        ),
        modifier = modifier
            .clickable(
                enabled = true,
                onClick = onClick
            )
    ) {
        Column{
            Image(
                painter = painterResource(symbolResourceId),
                contentDescription = "New Army Faction Card",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}