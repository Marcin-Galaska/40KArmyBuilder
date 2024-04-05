package com.example.a40karmybuilder.ui.factionoverviewlist

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a40karmybuilder.R
import com.example.a40karmybuilder.a40KArmyBuilderTopAppBar
import com.example.a40karmybuilder.ui.AppViewModelProvider
import com.example.a40karmybuilder.ui.navigation.NavigationDestination

object FactionOverviewListDestination : NavigationDestination {
    override val route = "faction_overview_list"
    override val titleRes = R.string.faction_overview_list_top_bar_text
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactionOverviewListScreen(
    navigateToCreatedArmiesList: () -> Unit,
    navigateToFactionOverview: () -> Unit,
    viewModel: FactionOverviewListViewModel = viewModel(factory = AppViewModelProvider.Factory),
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    //val UiState by viewModel.UiState.collectAsState()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            a40KArmyBuilderTopAppBar(
                title = stringResource(FactionOverviewListDestination.titleRes),
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding
        ) {
            items(factions) {
                FactionCard(
                    faction = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun FactionCard(
    faction: FactionOverviewInfo,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(dimensionResource(R.dimen.faction_overview_list_card_height))
            .clickable(
                onClick = { /* TODO */ }
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            Text(
                text = stringResource(faction.nameResourceId),
                style = MaterialTheme.typography.displayMedium,
                modifier = modifier
                    //.padding(dimensionResource(R.dimen.padding_small))
                    .align(Alignment.CenterVertically)
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
            FactionIcon(faction.logoResourceId)
        }
    }
}

@Composable
fun FactionIcon(
    @DrawableRes factionLogo: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(id = R.dimen.image_size))
            .padding(dimensionResource(id = R.dimen.padding_small)),
        contentScale = ContentScale.Fit,
        painter = painterResource(factionLogo),
        contentDescription = null
    )
}