package com.example.a40karmybuilder.ui.createdarmieslist

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.a40karmybuilder.a40KArmyBuilderBottomAppBar
import com.example.a40karmybuilder.a40KArmyBuilderNavigationFloatingButton
import com.example.a40karmybuilder.a40KArmyBuilderTopAppBar
import com.example.a40karmybuilder.ui.AppViewModelProvider
import com.example.a40karmybuilder.ui.navigation.NavigationDestination
import com.example.a40karmybuilder.ui.newarmycreator.NewArmyCreatorDestination
import com.example.a40karmybuilder.ui.newarmycreator.toArmy
import com.example.a40karmybuilder.ui.theme.Shapes
import com.example.a40karmybuilder.ui.unitselection.UnitSelectionViewModel
import kotlinx.coroutines.launch

object CreatedArmiesListDestination : NavigationDestination {
    override val route = "created_armies_list"
    override val titleRes = R.string.created_armies_list_top_bar_text
}

@SuppressLint("DiscouragedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatedArmiesListScreen(
    navController: NavHostController,
    navigateToArmyComposition: (Int) -> Unit,
    viewModel: CreatedArmiesListViewModel = viewModel(factory = AppViewModelProvider.factory),
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.armiesUiState.collectAsState()

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
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
        },
        floatingActionButton = {
            a40KArmyBuilderNavigationFloatingButton(
                onClick = { navController.navigate(NewArmyCreatorDestination.route) }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Image(
                modifier = modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(R.drawable.background_createdarmieslistscreen),
                contentDescription = "Background"
            )
            CreatedArmiesListBody(
                armyList = uiState.armyList,
                onCardClick = { navigateToArmyComposition(it.id) },
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}


@Composable
private fun CreatedArmiesListBody(
    armyList: List<Army>,
    onCardClick: (Army) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = if(armyList.isEmpty()) {
            Arrangement.Center
        } else {
            Arrangement.Top
        },
        modifier = modifier
            .fillMaxSize()
    ) {
        if(armyList.isEmpty()) {
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            )
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.Top,
                modifier = modifier
                    .fillMaxHeight()
            ) {
                items(items = armyList, key = { it.id }) { army ->
                    ArmyCard(
                        army = army,
                        onCardClick = {
                            UnitSelectionViewModel.currentArmy = army
                            onCardClick(army)
                        },
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
    viewModel: CreatedArmiesListViewModel = viewModel(factory = AppViewModelProvider.factory),
    maxArmyNameLength: Int = 30,
    modifier: Modifier = Modifier
) {
    val factionName = army.factionName
    val context = LocalContext.current

    val armyCardResourceId = context.resources.getIdentifier(
        army.factionDrawablePrefix + "_armycard",
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
            .fillMaxWidth()
            .height(140.dp)
            .clickable(
                onClick = onCardClick
            )
    ) {
        Box{
            Image(
                painter = painterResource(armyCardResourceId),
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
                    val armyName = if (army.armyName.length > maxArmyNameLength) {
                        army.armyName.take(maxArmyNameLength) + "..."
                    } else {
                        army.armyName
                    }

                    Text(
                        text = armyName.uppercase(),
                        color = Color.White,
                        style = MaterialTheme.typography.displayMedium.copy(
                            fontSize = 18.sp,
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(4f, 4f),
                                blurRadius = 8f
                            )
                        )
                    )
                    Text(
                        text = factionName,
                        color = Color.White,
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontSize = 14.sp,
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(4f, 4f),
                                blurRadius = 8f
                            )
                        )
                    )
                    Text(
                        text = buildAnnotatedString {
                            append("${army.maxPoints}")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Light)) {
                                append(" Points")
                            }
                        },
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontSize = 14.sp,
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(4f, 4f),
                                blurRadius = 8f
                            )
                        )
                    )
                }

                val coroutineScope = rememberCoroutineScope()
                ArmyOptionsMenu(
                    onDeleteClick = {
                        coroutineScope.launch {
                            viewModel.deleteArmy(army.id)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ArmyOptionsMenu(
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopEnd)
    ) {
        IconButton(
            onClick = { expanded = !expanded }
        ) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                tint = Color.White,
                contentDescription = "Army Card Settings Icon",
                modifier = modifier
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = modifier
                .background(colorResource(R.color.unit_card_black))
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = Shapes.extraSmall
                )
        ) {
            DropdownMenuItem(
                text = {
                    Text(
                        text = stringResource(R.string.created_armies_list_delete_army),
                        style = MaterialTheme.typography.displaySmall.copy(
                            fontSize = 14.sp
                        ),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = modifier
                            .fillMaxWidth()
                    )
                },
                onClick = {
                    onDeleteClick()
                    expanded = false
                },
                modifier = modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
                    .size(width = 90.dp, height = 40.dp)
            )
        }
    }
}