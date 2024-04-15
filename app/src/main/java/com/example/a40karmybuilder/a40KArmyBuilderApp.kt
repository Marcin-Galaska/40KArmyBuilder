@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.a40karmybuilder

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.a40karmybuilder.R.string
import com.example.a40karmybuilder.ui.navigation.a40KArmyBuilderNavHost

// Top level composable that represents screens for the application.
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun a40KArmyBuilderApp(navController: NavHostController = rememberNavController()) {
    a40KArmyBuilderNavHost(navController = navController)
}

@Composable
fun a40KArmyBuilderFloatingPointsButton(
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
            .offset(x = (-215).dp, y = 15.dp)
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

// Scaffold's top bar
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