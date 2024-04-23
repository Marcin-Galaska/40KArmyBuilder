package com.example.a40karmybuilder.ui.createdarmycomposition

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.a40karmybuilder.R
import com.example.a40karmybuilder.a40KArmyBuilderBottomAppBar
import com.example.a40karmybuilder.a40KArmyBuilderNavigationFloatingButton
import com.example.a40karmybuilder.a40KArmyBuilderPointsFloatingButton
import com.example.a40karmybuilder.a40KArmyBuilderTopAppBar
import com.example.a40karmybuilder.data.Unit
import com.example.a40karmybuilder.ui.AppViewModelProvider
import com.example.a40karmybuilder.ui.navigation.NavigationDestination
import com.example.a40karmybuilder.ui.unitselection.InvulnerableSavePanel
import com.example.a40karmybuilder.ui.unitselection.PointsCostCard
import com.example.a40karmybuilder.ui.unitselection.ShowUnitDetailsButton
import com.example.a40karmybuilder.ui.unitselection.StatsPanelRow
import com.example.a40karmybuilder.ui.unitselection.UnitSelectionDestination
import com.example.a40karmybuilder.ui.unitselection.UnitSelectionViewModel
import com.example.a40karmybuilder.ui.unitselection.WahapediaUriButton

object CreatedArmyCompositionDestination : NavigationDestination {
    override val route = "created_army_composition"
    override val titleRes = 0   // N/A
    const val armyIdArg = "armyId"
    val routeWithArgs = "$route/{$armyIdArg}"
}

@SuppressLint("DiscouragedApi", "StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatedArmyCompositionScreen(
    navController: NavHostController,
    navigateBack: () -> kotlin.Unit,
    maxArmyNameLength: Int = 30,
    viewModel: CreatedArmyCompositionViewModel = viewModel(factory = AppViewModelProvider.factory),
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.uiState.collectAsState().value
    val units = uiState.armyDetails.units

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val context = LocalContext.current

    val factionName = uiState.armyDetails.factionName
    val armyName = if (uiState.armyDetails.armyName.length > maxArmyNameLength) {
        uiState.armyDetails.armyName.take(maxArmyNameLength) + "..."
    } else {
        uiState.armyDetails.armyName
    }

    val colorResourceFactionName = factionName.replace(" ", "_").replace("'", "_").lowercase()
    val drawableResourceFactionName = uiState.armyDetails.factionDrawablePrefix

    val backgroundResourceId = context.resources.getIdentifier(
        drawableResourceFactionName + "_background",
        "drawable",
        context.packageName
    )
    val primaryColorResourceId = context.resources.getIdentifier(
        colorResourceFactionName + "_primary",
        "color",
        context.packageName
    )
    val secondaryColorResourceId = context.resources.getIdentifier(
        colorResourceFactionName + "_secondary",
        "color",
        context.packageName
    )

    Scaffold(
        modifier = modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxSize(),
        floatingActionButtonPosition = FabPosition.End,
        topBar = {
            a40KArmyBuilderTopAppBar(
                title = armyName.uppercase(),
                canNavigateBack = true,
                navigateUp = navigateBack,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                a40KArmyBuilderPointsFloatingButton(
                    onClick = { /* TODO */ },
                    maxPoints = viewModel.uiState.value.armyDetails.maxPoints.toInt(),
                    currentPoints = viewModel.uiState.value.armyDetails.currentPoints,
                    color = colorResource(secondaryColorResourceId),
                    modifier = Modifier
                        .padding(start = dimensionResource(R.dimen.padding_medium))
                        .offset(y = 14.dp)
                )
                a40KArmyBuilderNavigationFloatingButton(
                    onClick = { navController.navigate(UnitSelectionDestination.route) },
                    containerColor = colorResource(secondaryColorResourceId),
                    contentColor = Color.White,
                )
            }
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
                .padding(innerPadding)
        ) {
            Image(
                modifier = modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(backgroundResourceId),
                contentDescription = "Background"
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = if(units.isEmpty()) {
                    Arrangement.Center
                } else {
                    Arrangement.Top
                },
                modifier = Modifier
                    .fillMaxSize()
            ) {
                if(units.isEmpty()) {
                    Text(
                        text = stringResource(R.string.created_army_composition_no_units_message),
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
                        items(units) {
                            CreatedArmyUnitCard(
                                unit = it,
                                context = context,
                                primaryColorResourceId = primaryColorResourceId,
                                secondaryColorResourceId = secondaryColorResourceId,
                                modifier = Modifier
                                    .padding(dimensionResource(R.dimen.padding_tiny))
                            )
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("DiscouragedApi")
@Composable
private fun CreatedArmyUnitCard(
    unit: Unit,
    context: Context,
    primaryColorResourceId: Int,
    secondaryColorResourceId: Int,
    modifier: Modifier = Modifier
) {
    var expanded by remember{
        mutableStateOf(false)
    }

    val factionName = UnitSelectionViewModel.selectedUnitsFactionName
    val cardResourceId = context.resources.getIdentifier(
        factionName.replace("_", "") + "_card",
        "drawable",
        context.packageName
    )

    val mValues = unit.m.split('/')
    val tValues = unit.t.split('/')
    val svValues = unit.sv.split('/')
    val wValues = unit.w.split('/')
    val ldValues = unit.ld.split('/')
    val ocValues = unit.oc.split('/')
    val invulSavesValues = unit.invulnerableSave?.split('/')

    val wahapediaUrlUnitName = unit.name.replace(" ", "-").replace("’", "-")
    val wahapediaUrl = "https://wahapedia.ru/wh40k10ed/factions/" + factionName.replace("_", "-") + "/" + wahapediaUrlUnitName

    Card(
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(1.dp, colorResource(secondaryColorResourceId)),
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .background(colorResource(R.color.unit_card_black))
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            stiffness = Spring.StiffnessMedium
                        )
                    )
            ) {
                Box(
                    modifier = Modifier
                        .background(colorResource(primaryColorResourceId))
                        .fillMaxWidth()
                        .height(55.dp)
                ) {
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
                            text = unit.name,
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontSize = 14.sp,
                                shadow = Shadow(
                                    color = Color.Black,
                                    offset = Offset(4f, 4f),
                                    blurRadius = 8f
                                )
                            ),
                            color = Color.White,
                            modifier = Modifier
                                .weight(1f)
                                .padding(
                                    start = dimensionResource(R.dimen.padding_medium),
                                    end = dimensionResource(R.dimen.padding_tiny)
                                )
                                .align(Alignment.CenterVertically),
                        )
                        PointsCostCard(
                            pointsCost = unit.pointsCost,
                            colorResourceId = secondaryColorResourceId,
                            modifier = modifier
                                .align(Alignment.CenterVertically)
                        )
                        ShowUnitDetailsButton(
                            expanded = expanded,
                            onClick = { expanded = !expanded },
                            modifier = modifier
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
                Text(
                    text = unit.composition,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.White,
                    modifier = modifier
                        .padding(dimensionResource(R.dimen.padding_small))
                )
                if(expanded){
                    Column{
                        for (i in 0 until mValues.count()) {
                            StatsPanelRow(
                                colorResourceId = secondaryColorResourceId,
                                m = mValues[i],
                                t = tValues[i],
                                sv = svValues[i],
                                w = wValues[i],
                                ld = ldValues[i],
                                oc = ocValues[i]
                            )
                            invulSavesValues?.get(i)?.let {
                                if (it != "")
                                    InvulnerableSavePanel(
                                        invulnerableSaveValue = it,
                                        colorResourceId = secondaryColorResourceId,
                                        scale = 0.80f
                                    )
                            }
                        }
                        WahapediaUriButton(
                            url = wahapediaUrl,
                            color = colorResource(secondaryColorResourceId)
                        )
                    }
                }
            }
        }
    }
}