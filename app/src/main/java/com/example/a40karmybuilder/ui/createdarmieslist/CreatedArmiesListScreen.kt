package com.example.a40karmybuilder.ui.createdarmieslist

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a40karmybuilder.R
import com.example.a40karmybuilder.data.Army
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.a40karmybuilder.a40KArmyBuilderBottomAppBar
import com.example.a40karmybuilder.a40KArmyBuilderTopAppBar
import com.example.a40karmybuilder.ui.navigation.NavigationDestination
import com.example.a40karmybuilder.ui.newarmy.NewArmyDetailsDestination

object CreatedArmiesListDestination : NavigationDestination {
    override val route = "created_armies_list"
    override val titleRes = R.string.created_armies_list_top_bar_text
}

@SuppressLint("DiscouragedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatedArmiesListScreen(
    navController: NavHostController,
    viewModel: CreatedArmiesListViewModel = viewModel(factory = CreatedArmiesListViewModel.factory),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.armiesUiState.collectAsState()

    Scaffold(
        modifier = modifier,
        topBar = {
            a40KArmyBuilderTopAppBar(
                title = stringResource(CreatedArmiesListDestination.titleRes),
                canNavigateBack = false
            )
        },
        bottomBar = {
            a40KArmyBuilderBottomAppBar(
                navController = navController
            )
        }
    ) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            Image(
                modifier = modifier.fillMaxHeight(),
                contentScale = ContentScale.FillHeight,
                painter = painterResource(R.drawable.background_createdarmieslistscreen),
                contentDescription = "Background"
            )
            CreatedArmiesListBody(
                armyList = uiState.armyList,
                onCardClick = { /* TODO */ },
                onSettingsIconClick = { /* TODO */ },
                modifier = modifier
                    .padding(innerPadding)
            )
        }

    }
}

@Composable
private fun CreatedArmiesListBody(
    armyList: List<Army>,
    onCardClick: (Int) -> Unit,
    onSettingsIconClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        if (armyList.isEmpty()) {
            Text(
                text = stringResource(R.string.created_armies_list_no_armies_message),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayMedium.copy(
                    fontSize = 26.sp,
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(4f, 4f),
                        blurRadius = 8f
                    )
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            )
        } else {
            LazyColumn(
                modifier = modifier
            ) {
                items(items = armyList, key = { it.id }) { army ->
                    ArmyCard(
                        army = army,
                        onCardClick = { /* TODO */ },
                        onSettingsIconClick = { /* TODO */ },
                        modifier = Modifier
                            .padding(dimensionResource(id = R.dimen.padding_small))
                    )
                }
            }
        }
    }
}


@SuppressLint("DiscouragedApi")
@Composable
fun ArmyCard(
    army: Army,
    onCardClick: () -> Unit,
    onSettingsIconClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val factionName = army.factionName

    Card(
        shape = MaterialTheme.shapes.large,
        modifier = modifier
            .fillMaxWidth()
            .height(140.dp)
            .clickable(
                onClick = onCardClick
            )
    ) {
        Box{
            Image(
                painter = painterResource(R.drawable.background_factionoverviewlistscreen),
                contentDescription = "Army Card Background Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier
                        .padding(dimensionResource(R.dimen.padding_tiny))
                ) {
                    Text(
                        text = army.armyName,
                        style = MaterialTheme.typography.displayMedium.copy(
                            fontSize = 18.sp
                        )
                    )
                    Text(
                        text = factionName,
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontSize = 14.sp
                        )
                    )
                }
                IconButton(
                    onClick = onSettingsIconClick,
                    modifier = modifier
                ) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        tint = Color.White,
                        contentDescription = "Army Card Settings Icon",
                        modifier = modifier
                            .align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}