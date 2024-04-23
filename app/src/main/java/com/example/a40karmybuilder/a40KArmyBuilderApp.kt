@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.a40karmybuilder

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.a40karmybuilder.R.string
import com.example.a40karmybuilder.ui.createdarmieslist.CreatedArmiesListDestination
import com.example.a40karmybuilder.ui.factionoverviewlist.FactionOverviewListDestination
import com.example.a40karmybuilder.ui.navigation.a40KArmyBuilderNavHost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun a40KArmyBuilderApp(navController: NavHostController = rememberNavController()) {
    a40KArmyBuilderNavHost(navController = navController)
}

@Composable
fun a40KArmyBuilderNavigationFloatingButton(
    onClick: () -> Unit,
    containerColor: Color = colorResource(R.color.unit_card_black),
    contentColor: Color = MaterialTheme.colorScheme.primary,
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        containerColor = containerColor,
        modifier = Modifier
            .size(width = 95.dp, height = 95.dp)
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Card(
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            ),
            border = BorderStroke(width = 1.dp, color = contentColor),
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxSize()
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(R.string.created_armies_list_floating_button_icon),
                    tint = contentColor,
                    modifier = modifier
                        .scale(1.5f)
                )
            }
        }
    }
}

@Composable
fun a40KArmyBuilderPointsFloatingButton(
    onClick: () -> Unit,
    maxPoints: Int = 2000,
    currentPoints: Int = 0,
    color: Color,
    modifier: Modifier = Modifier
) {
    val pointsString = "$currentPoints/$maxPoints"

    FloatingActionButton(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        containerColor = Color.White,
        modifier = modifier
            .size(width = 130.dp, height = 80.dp)

            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Card(
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(
                containerColor = color
            ),
            modifier = Modifier
                .fillMaxSize()
                .padding(1.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = pointsString,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontSize = 16.sp,
                    ),
                    modifier = Modifier
                        .padding(top = dimensionResource(R.dimen.padding_tiny))
                )
                Text(
                    text = "POINTS",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .padding(bottom = dimensionResource(R.dimen.padding_tiny))
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun a40KArmyBuilderTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.displayMedium
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = colorResource(R.color.unit_card_black)
        ),
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Filled.KeyboardArrowLeft,
                        contentDescription = stringResource(string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun a40KArmyBuilderBottomAppBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    BottomAppBar(
        actions = {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxSize()
            ){
                BottomAppBarActionCard(
                    onClick = { navController.navigate(FactionOverviewListDestination.route) },
                    imageResourceId = R.drawable.typography_bottom_bar_faction_overview,
                    text = stringResource(R.string.bottom_bar_faction_overview),
                    contentDescription = "Bottom Bar Faction Overview Button Card"
                )
                BottomAppBarActionCard(
                    onClick = { navController.navigate(CreatedArmiesListDestination.route) },
                    imageResourceId = R.drawable.typography_bottom_bar_army_lists,
                    text = stringResource(R.string.bottom_bar_army_lists),
                    contentDescription = "Bottom Bar Army Lists Button Card"
                )
            }
        },
        containerColor = colorResource(R.color.unit_card_black),
        modifier = modifier
            .height(110.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAppBarActionCard(
    onClick: () -> Unit,
    imageResourceId: Int,
    text: String,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .width(110.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(vertical = dimensionResource(R.dimen.padding_tiny))
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                contentScale = ContentScale.FillWidth,
                modifier = modifier
                    .size(width = 50.dp, height = 30.dp)
                    .scale(0.8f),
                painter = painterResource(imageResourceId),
                contentDescription = contentDescription
            )
            Text(
                text = text,
                style = MaterialTheme.typography.displaySmall.copy(
                    fontSize = 14.sp
                ),
                color = Color.White
            )
        }
    }
}