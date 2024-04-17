package com.example.a40karmybuilder.ui.unitselection

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.a40karmybuilder.R
import com.example.a40karmybuilder.a40KArmyBuilderBottomAppBar
import com.example.a40karmybuilder.a40KArmyBuilderPointsFloatingButton
import com.example.a40karmybuilder.a40KArmyBuilderTopAppBar
import com.example.a40karmybuilder.ui.factionoverviewlist.FactionViewModel
import com.example.a40karmybuilder.ui.navigation.NavigationDestination

object UnitSelectionDestination : NavigationDestination {
    override val route = "unit_selection"
    override val titleRes = R.string.unit_selection_top_bar_text
}

@SuppressLint("DiscouragedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitSelectionScreen(
    navController: NavHostController,
    units: List<com.example.a40karmybuilder.data.Unit>,
    navigateBack: () -> Unit,
    viewModel: UnitSelectionViewModel = viewModel(factory = UnitSelectionViewModel.factory),
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val context = LocalContext.current

    val factionName = UnitSelectionViewModel.selectedUnitsFactionName
    val backgroundResourceId = context.resources.getIdentifier(
        factionName.replace("_", "") + "_background",
        "drawable",
        context.packageName
    )
    val primaryColorResourceId = context.resources.getIdentifier(
        factionName + "_primary",
        "color",
        context.packageName
    )
    val secondaryColorResourceId = context.resources.getIdentifier(
        factionName + "_secondary",
        "color",
        context.packageName
    )

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        floatingActionButtonPosition = FabPosition.End,
        topBar = {
            a40KArmyBuilderTopAppBar(
                title = stringResource(UnitSelectionDestination.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            a40KArmyBuilderPointsFloatingButton(
                onClick = { /* TODO */ },
                maxPoints = 2000,
                currentPoints = 0,
                color = colorResource(secondaryColorResourceId)
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
                modifier = modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(backgroundResourceId),
                contentDescription = "Background"
            )
            LazyColumn(
                contentPadding = innerPadding
            ) {
                items(units) {
                    UnitSelectionCard(
                        unit = it,
                        context = context,
                        primaryColorResourceId = primaryColorResourceId,
                        secondaryColorResourceId = secondaryColorResourceId,
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_tiny))
                    )
                }
            }
        }
    }
}

@SuppressLint("DiscouragedApi")
@Composable
fun UnitSelectionCard(
    unit: com.example.a40karmybuilder.data.Unit,
    context: Context,
    primaryColorResourceId: Int,
    secondaryColorResourceId: Int,
    viewModel: FactionViewModel = viewModel(factory = FactionViewModel.factory),
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
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier
                ) {
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
                    }
                    Spacer(modifier = modifier.weight(2f))
                    UnitCountControls(
                        onAddClick = { /*TODO*/ },
                        onSubtractClick = { /*TODO*/ },
                        color = colorResource(secondaryColorResourceId),
                        scale = .5f,
                        modifier = modifier
                            .padding(horizontal = dimensionResource(R.dimen.padding_medium))
                    )
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
                if(expanded) {
                    UnitDetails(
                        description = unit.description,
                        keywords = unit.keywords,
                        wahapediaUrl = wahapediaUrl,
                        secondaryColor = colorResource(secondaryColorResourceId),
                    )
                    Spacer(
                        modifier = modifier
                            .height(2.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun PointsCostCard(
    pointsCost: Int,
    colorResourceId: Int,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = colorResource(colorResourceId)
        ),
        modifier = modifier
    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(pointsCost.toString())
                }
                append(" Points")
            },
            style = MaterialTheme.typography.labelSmall.copy(
                fontSize = 12.sp
            ),
            color = Color.White,
            modifier = modifier
        )
    }
}

@Composable
private fun StatsPanelRow(
    colorResourceId: Int,
    m: String,
    t: String,
    sv: String,
    w: String,
    ld: String,
    oc: String,
    modifier: Modifier = Modifier
) {
    Row{
        StatsPanel(
            statName = "M",
            statValue = m,
            colorResourceId = colorResourceId
        )
        StatsPanel(
            statName = "T",
            statValue = t,
            colorResourceId = colorResourceId
        )
        StatsPanel(
            statName = "Sv",
            statValue = sv,
            colorResourceId = colorResourceId
        )
        StatsPanel(
            statName = "W",
            statValue = w,
            colorResourceId = colorResourceId
        )
        StatsPanel(
            statName = "Ld",
            statValue = ld,
            colorResourceId = colorResourceId
        )
        StatsPanel(
            statName = "Oc",
            statValue = oc,
            colorResourceId = colorResourceId
        )
    }
}

@Composable
private fun StatsPanel(
    statName: String,
    statValue: String,
    colorResourceId: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = statName,
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Bold
            ),
            color = Color.White,
            modifier = modifier
        )
        Box(
            modifier = modifier
        ) {
            TintedImage(
                imageResourceId = R.drawable.unit_stat_frame,
                colorResourceId = colorResourceId,
                scale = 0.9f
            )
            TintedImage(
                imageResourceId = R.drawable.unit_stat_frame,
                colorResourceId = R.color.unit_stats_white,
                scale = 0.8f
            )
            Text(
                text = statValue,
                style = MaterialTheme.typography.labelLarge,
                color = colorResource(colorResourceId),
                modifier = modifier
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
private fun InvulnerableSavePanel(
    colorResourceId: Int,
    invulnerableSaveValue: String,
    scale: Float = 1f,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .scale(scale)
            .offset(x = 60.dp, y = (-6).dp)
    ) {
        TintedImage(
            imageResourceId = R.drawable.unit_invul_save_outer,
            colorResourceId = colorResourceId
        )
        TintedImage(
            imageResourceId = R.drawable.unit_invul_save_inner,
            colorResourceId = R.color.unit_stats_white
        )
        Text(
            text = invulnerableSaveValue,
            style = MaterialTheme.typography.labelLarge.copy(
                fontSize = 24.sp
            ),
            color = colorResource(colorResourceId),
            modifier = modifier
                .offset(x = 21.dp, y = 6.dp)
        )
    }
}

@Composable
private fun TintedImage(
    imageResourceId: Int,
    colorResourceId: Int,
    scale: Float = 1f,
    modifier: Modifier = Modifier
) {
    val color = colorResource(colorResourceId)

    Image(
        painter = painterResource(imageResourceId),
        contentDescription = null,
        colorFilter = ColorFilter.tint(color),
        modifier = modifier
            .scale(scale)
    )
}

@Composable
private fun ShowUnitDetailsButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) {
                Icons.Filled.KeyboardArrowUp
            }
            else {
                Icons.Filled.KeyboardArrowDown
            },
            contentDescription = stringResource(R.string.show_unit_details_button),
            tint = Color.White
        )
    }
}

@Composable
private fun UnitDetails(
    description: String,
    keywords: String,
    wahapediaUrl: String,
    secondaryColor: Color,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("KEYWORDS: ")
                }
                append(keywords)
            },
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.bodySmall,
            color = Color.White,
            modifier = modifier
                .padding(dimensionResource(R.dimen.padding_small))
        )
        Image(
            modifier = modifier
                .padding(
                    horizontal = dimensionResource(R.dimen.padding_small),
                    vertical = dimensionResource(R.dimen.padding_tiny)
                )
                .size(20.dp),
            contentScale = ContentScale.Fit,
            painter = painterResource(R.drawable.typography_quotes_upper),
            contentDescription = "Quote Symbol Upper"
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.bodySmall,
            fontStyle = FontStyle.Italic,
            color = Color.White,
            modifier = modifier
                .padding(horizontal = dimensionResource(R.dimen.padding_medium))
        )
        Image(
            modifier = modifier
                .padding(
                    horizontal = dimensionResource(R.dimen.padding_small),
                    vertical = dimensionResource(R.dimen.padding_tiny)
                )
                .size(20.dp)
                .align(Alignment.End),
            contentScale = ContentScale.Fit,
            painter = painterResource(R.drawable.typography_quotes_lower),
            contentDescription = "Quote Symbol Upper"
        )
        WahapediaUriButton(
            url = wahapediaUrl,
            color = secondaryColor,
            modifier = modifier
        )
    }
}

@Composable
private fun WahapediaUriButton(
    url: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val intent = remember {
        Intent(Intent.ACTION_VIEW, Uri.parse(url))
    }

    OutlinedButton(
        onClick = { context.startActivity(intent) },
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = color,
        ),
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(1.dp, color),
        modifier = modifier
            .fillMaxWidth()
            .height(45.dp)
            .padding(
                horizontal = dimensionResource(R.dimen.padding_small),
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
                painter = painterResource(R.drawable.uri_wahapedia),
                contentDescription = "Wahapedia Uri Button"
            )
            Text(
                text = "Wahapedia",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = color,
                modifier = modifier
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
private fun UnitCountControls(
    onAddClick: () -> Unit,
    onSubtractClick: () -> Unit,
    color: Color,
    unitCount: Int = 0,
    scale: Float = 1f,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(width = 2.dp * scale, color = Color.White),
        colors = CardDefaults.cardColors(containerColor = color),
        modifier = Modifier
            .scale(scale)
            .offset(x = (-20).dp, y = (-35).dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(vertical = dimensionResource(R.dimen.padding_medium) * scale)
        ) {
            IconButton(
                onClick = onAddClick,
                modifier = Modifier.scale(2f)
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowUp,
                    contentDescription = stringResource(R.string.unit_add_button),
                    tint = Color.White
                )
            }
            Text(
                text = unitCount.toString(),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White,
                modifier = Modifier.scale(2f)
            )
            IconButton(
                onClick = onSubtractClick,
                modifier = Modifier.scale(2f)
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = stringResource(R.string.unit_subtract_button),
                    tint = Color.White
                )
            }
        }
    }
}