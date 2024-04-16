package com.example.a40karmybuilder.ui.newarmy

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.a40karmybuilder.R
import com.example.a40karmybuilder.a40KArmyBuilderBottomAppBar
import com.example.a40karmybuilder.a40KArmyBuilderTopAppBar
import com.example.a40karmybuilder.data.Army
import com.example.a40karmybuilder.ui.navigation.NavigationDestination

object NewArmyDetailsDestination : NavigationDestination {
    override val route = "new_army_details"
    override val titleRes = R.string.new_army_details_top_bar_text
}

@SuppressLint("DiscouragedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewArmyDetailsScreen(
    navController: NavHostController,
    navigateToCreatedArmyComposition: () -> Unit,
    navigateBack: () -> Unit,
    army: Army,
    modifier: Modifier = Modifier
) {
    // WAŻNE, UŻYĆ PÓŹNIEJ
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    val logoResourceId = context.resources.getIdentifier(
        army.factionDrawablePrefix + "_logo",
        "drawable",
        context.packageName
    )

    Scaffold(
        modifier = modifier,
        topBar = {
            a40KArmyBuilderTopAppBar(
                title = stringResource(NewArmyDetailsDestination.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack
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
                .padding(innerPadding)
        ) {
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
            NewArmyDetailsInputForm(
                army = army,
                onValueChange = { /* TODO */ },
                modifier = modifier
                    .padding(horizontal = dimensionResource(R.dimen.padding_tiny))
            )
            Text(
                text = stringResource(R.string.new_army_details_recommended_max_points),
                style = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 10.sp
                ),
                textAlign = TextAlign.End,
                color = Color.White,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_tiny))
            )
            OutlinedButton(
                onClick = navigateToCreatedArmyComposition,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_small),
                        horizontal = dimensionResource(R.dimen.padding_tiny)
                    )
            ) {
                Text(
                    text = stringResource(R.string.new_army_details_create_army),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@Composable
fun NewArmyDetailsInputForm(
    army: Army,
    onValueChange: (Army) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
    ) {
        OutlinedTextField(
            shape = MaterialTheme.shapes.medium,
            value = army.armyName,
            onValueChange = { onValueChange(army.copy(armyName = it)) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            label = {
                Text(
                    text = stringResource(R.string.new_army_details_label_army_name),
                    style = MaterialTheme.typography.displaySmall
                )
            },
//            colors = OutlinedTextFieldDefaults.colors(
//                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//            ),
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true
        )
        OutlinedTextField(
            shape = MaterialTheme.shapes.medium,
            value = army.maxPoints.toString(),
            onValueChange = { onValueChange(army.copy(maxPoints = it.toInt())) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            label = {
                Text(
                    text = stringResource(R.string.new_army_details_label_max_points),
                    style = MaterialTheme.typography.displaySmall
                )
            },
//            colors = OutlinedTextFieldDefaults.colors(
//                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
//            ),
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true
        )
    }
}