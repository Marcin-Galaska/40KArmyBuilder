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
import androidx.appcompat.widget.AppCompatTextView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.widget.TextViewCompat.setTextAppearance
import androidx.navigation.NavHostController
import com.example.a40karmybuilder.a40KArmyBuilderBottomAppBar
import kotlinx.coroutines.flow.first

object FactionOverviewListDestination : NavigationDestination {
    override val route = "faction_overview_list"
    override val titleRes = R.string.faction_overview_list_top_bar_text
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactionOverviewListScreen(
    navController: NavHostController,
    navigateToFactionDetails: () -> Unit,
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
                title = stringResource(FactionOverviewListDestination.titleRes),
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            a40KArmyBuilderBottomAppBar(
                navController = navController
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                contentScale = ContentScale.FillWidth,
                painter = painterResource(R.drawable.background_factionoverviewlistscreen),
                contentDescription = "Background",
                modifier = modifier
                    .fillMaxSize(),
            )
            LazyColumn(
                contentPadding = innerPadding
            ) {
                items(allFactions) {
                    FactionCard(
                        faction = it,
                        onCardClick = navigateToFactionDetails,
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_tiny))
                    )
                }
            }
        }
    }
}

@SuppressLint("DiscouragedApi")
@Composable
fun FactionCard(
    faction: Faction,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val factionName = faction.name
    val logoResourceId = context.resources.getIdentifier(
        faction.drawablePrefix + "_logo",
        "drawable",
        context.packageName
    )
    val cardResourceId = context.resources.getIdentifier(
        faction.drawablePrefix + "_card",
        "drawable",
        context.packageName
    )

    Card(
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(width = 1.dp, color = colorResource(R.color.unit_card_black)),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.unit_card_black)
        ),
        modifier = modifier
            .height(dimensionResource(R.dimen.faction_overview_list_card_height))
            .clickable(
                onClick = {
                    FactionViewModel.selectedFactionId = faction.id
                    onCardClick()
                }
            )
    ) {
        Box{
            Image(
                painter = painterResource(cardResourceId),
                contentDescription = "Faction Card Background Image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxSize()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                Text(
                    text = factionName,
                    style = MaterialTheme.typography.displayMedium.copy(
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(4f, 4f),
                            blurRadius = 8f
                        )
                    ),
                    modifier = modifier
                        .align(Alignment.CenterVertically)
                )
                Spacer(
                    modifier = Modifier.weight(1f)
                )
                FactionIcon(logoResourceId)
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Faction Card Right Arrow",
                    modifier = modifier
                        .align(Alignment.CenterVertically)
                )
            }
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
            .padding(dimensionResource(id = R.dimen.padding_small)),
        contentScale = ContentScale.Fit,
        painter = painterResource(factionLogo),
        contentDescription = "Faction Logo"
    )
}