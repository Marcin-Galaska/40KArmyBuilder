package com.example.a40karmybuilder.ui.factionoverviewdetails

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.a40karmybuilder.R
import com.example.a40karmybuilder.a40KArmyBuilderBottomAppBar
import com.example.a40karmybuilder.a40KArmyBuilderTopAppBar
import com.example.a40karmybuilder.data.Faction
import com.example.a40karmybuilder.ui.factionoverviewlist.FactionViewModel
import com.example.a40karmybuilder.ui.navigation.NavigationDestination

object FactionOverviewDetailsDestination : NavigationDestination {
    override val route = "faction_overview_details"
    override val titleRes = R.string.faction_overview_details_top_bar_text
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("DiscouragedApi")
@Composable
fun FactionOverviewDetailsScreen(
    navController: NavHostController,
    faction: Faction,
    navigateBack: () -> Unit,
    viewModel: FactionViewModel = viewModel(factory = FactionViewModel.factory),
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val context = LocalContext.current
    val bannerResourceId = context.resources.getIdentifier(
        faction.drawablePrefix + "_banner",
        "drawable",
        context.packageName
    )
    val logoResourceId = context.resources.getIdentifier(
        faction.drawablePrefix + "_logo",
        "drawable",
        context.packageName
    )
    // val UiState by viewModel.UiState.collectAsState()

    Scaffold(
        modifier = modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            a40KArmyBuilderTopAppBar(
                title = faction.name,
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
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                modifier = modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit,
                painter = painterResource(bannerResourceId),
                contentDescription = "Faction Banner"
            )
            Text(
                text = faction.description,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .padding(horizontal = dimensionResource(R.dimen.padding_medium), vertical = dimensionResource(R.dimen.padding_medium))
            )
            Image(
                modifier = modifier
                    .padding(
                        horizontal = dimensionResource(R.dimen.padding_medium),
                        vertical = dimensionResource(R.dimen.padding_tiny)
                    )
                    .size(30.dp),
                contentScale = ContentScale.Fit,
                painter = painterResource(R.drawable.typography_quotes_upper),
                contentDescription = "Quote Symbol Upper"
            )
            Text(
                text = faction.quote,
                style = MaterialTheme.typography.bodySmall,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .padding(horizontal = dimensionResource(R.dimen.padding_medium), vertical = dimensionResource(R.dimen.padding_tiny))
            )
            Text(
                text = "— " + faction.quoteSource,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.End,
                modifier = modifier
                    .padding(
                        horizontal = dimensionResource(R.dimen.padding_medium),
                        vertical = dimensionResource(R.dimen.padding_tiny)
                    )
                    .align(Alignment.End)
            )
            Image(
                modifier = modifier
                    .padding(
                        horizontal = dimensionResource(R.dimen.padding_medium),
                        vertical = dimensionResource(R.dimen.padding_tiny)
                    )
                    .size(30.dp)
                    .align(Alignment.End),
                contentScale = ContentScale.Fit,
                painter = painterResource(R.drawable.typography_quotes_lower),
                contentDescription = "Quote Symbol Upper"
            )
            Image(
                modifier = modifier
                    .padding(
                        horizontal = dimensionResource(R.dimen.padding_tiny),
                        vertical = dimensionResource(R.dimen.padding_tiny)
                    )
                    .size(150.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit,
                painter = painterResource(logoResourceId),
                contentDescription = "Faction Logo"
            )
            UriButtonSet(
                modifier = modifier,
                faction = faction
            )
        }
    }
}

@Composable
private fun UriButtonSet(
    faction: Faction,
    modifier: Modifier = Modifier
){
    UriButton(
        modifier = modifier,
        url = faction.gamesWorkshopUrl,
        imageResourceId = R.drawable.uri_games_workshop,
        text = "Games Workshop Store",
        buttonColor = colorResource(R.color.games_workshop_green),
        contentDescription = "Uri Games Workshop Store Button"
    )
    UriButton(
        modifier = modifier,
        url = faction.wahapediaUrl,
        imageResourceId = R.drawable.uri_wahapedia,
        text = "Wahapedia",
        buttonColor = colorResource(R.color.wahapedia_red),
        contentDescription = "Uri Wahapedia Button"
    )
    UriButton(
        modifier = modifier,
        url = faction.warhammerWikiUrl,
        imageResourceId = R.drawable.uri_warhammer_wiki,
        text = "Warhammer Wiki",
        buttonColor = colorResource(R.color.warhammer_wiki_blue),
        contentDescription = "Uri Warhammer Wiki Button"
    )
}

@Composable
private fun UriButton(
    url: String,
    imageResourceId: Int,
    text: String,
    buttonColor: Color,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val intent = remember {
        Intent(Intent.ACTION_VIEW, Uri.parse(url))
    }

    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor
        ),
        shape = MaterialTheme.shapes.medium,
        onClick = { context.startActivity(intent) },
        modifier = modifier
            .fillMaxWidth()
            .height(45.dp)
            .padding(
                horizontal = dimensionResource(R.dimen.padding_tiny),
                vertical = dimensionResource(R.dimen.padding_tiny)
            )
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Image(
                modifier = modifier
                    .size(40.dp)
                    .align(Alignment.CenterStart),
                contentScale = ContentScale.Inside,
                painter = painterResource(imageResourceId),
                contentDescription = contentDescription
            )
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                modifier = modifier
                    .align(Alignment.Center)
            )
        }
    }
}