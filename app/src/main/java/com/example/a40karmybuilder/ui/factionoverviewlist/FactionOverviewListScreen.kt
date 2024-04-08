package com.example.a40karmybuilder.ui.factionoverviewlist

import android.annotation.SuppressLint
import android.content.Context
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a40karmybuilder.R
import com.example.a40karmybuilder.a40KArmyBuilderTopAppBar
import com.example.a40karmybuilder.data.Faction
import com.example.a40karmybuilder.ui.navigation.NavigationDestination
import android.content.res.Resources
import androidx.compose.ui.platform.LocalContext

object FactionOverviewListDestination : NavigationDestination {
    override val route = "faction_overview_list"
    override val titleRes = R.string.faction_overview_list_top_bar_text
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactionOverviewListScreen(
    navigateToFactionDetails: (Int) -> Unit,
    viewModel: FactionViewModel = viewModel(factory = FactionViewModel.factory),
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val allFactions by viewModel.getAllFactions().collectAsState(emptyList())
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
            items(allFactions) {
                FactionCard(
                    faction = it,
                    onCardClick = navigateToFactionDetails,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@SuppressLint("DiscouragedApi")
@Composable
fun FactionCard(
    faction: Faction,
    onCardClick: (Int) -> Unit,
    // viewModel: FactionViewModel = viewModel(factory = FactionViewModel.factory),
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val factionName = faction.name
    val logoResourceId = context.resources.getIdentifier(
        faction.drawablePrefix + "_logo",
        "drawable",
        context.packageName
    )
    // val onClick by viewModel.getFaction(id = faction.id).collectAsState(null)

    Card(
        shape = MaterialTheme.shapes.large,
        modifier = modifier
            .height(dimensionResource(R.dimen.faction_overview_list_card_height))
            .clickable(
                onClick = { onCardClick(faction.id) }
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            Text(
                text = factionName,
                style = MaterialTheme.typography.displayMedium,
                modifier = modifier
                    //.padding(dimensionResource(R.dimen.padding_small))
                    .align(Alignment.CenterVertically)
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
            FactionIcon(logoResourceId)
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
        contentDescription = "Faction Logo"
    )
}