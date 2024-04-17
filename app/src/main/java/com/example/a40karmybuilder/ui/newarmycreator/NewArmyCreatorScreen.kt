package com.example.a40karmybuilder.ui.newarmycreator

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.a40karmybuilder.R
import com.example.a40karmybuilder.a40KArmyBuilderBottomAppBar
import com.example.a40karmybuilder.a40KArmyBuilderTopAppBar
import com.example.a40karmybuilder.ui.navigation.NavigationDestination
import kotlinx.coroutines.launch

object NewArmyCreatorDestination : NavigationDestination {
    override val route = "item_entry"
    override val titleRes = R.string.new_army_creator_top_bar_text
}

@SuppressLint("DiscouragedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewArmyCreatorScreen(
    navController: NavHostController,
    navigateBack: () -> Unit,
    viewModel: NewArmyCreatorViewModel = viewModel(factory = NewArmyCreatorViewModel.factory),
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    val chosenFactionDrawablePrefix = viewModel.armyUiState.armyDetails.factionDrawablePrefix
    val logoResourceId = if(chosenFactionDrawablePrefix.isNotBlank()) {
        context.resources.getIdentifier(
            chosenFactionDrawablePrefix + "_logo",
            "drawable",
            context.packageName
        )
    } else {
        R.drawable.typography_bottom_bar_army_lists
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            a40KArmyBuilderTopAppBar(
                title = stringResource(NewArmyCreatorDestination.titleRes),
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
            NewArmyCreatorInputForm(
                armyUiState = viewModel.armyUiState,
                onArmyValueChange = viewModel::updateUiState,
                modifier = modifier
            )
            Text(
                text = stringResource(R.string.new_army_creator_recommended_max_points),
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
                onClick = {
                    coroutineScope.launch {
                        viewModel.saveArmy()
                        navigateBack()
                    }
                },
                enabled = viewModel.armyUiState.isEntryValid,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_small),
                        horizontal = dimensionResource(R.dimen.padding_tiny)
                    )
            ) {
                Text(
                    text = stringResource(R.string.new_army_creator_create_army),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewArmyCreatorInputForm(
    armyUiState: ArmyUiState,
    onArmyValueChange: (ArmyDetails) -> Unit,
    modifier: Modifier = Modifier
) {
    val armyDetails = armyUiState.armyDetails

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ) {
        var expanded by remember { mutableStateOf(false) }
        val allFactions by remember { mutableStateOf(factionList) }

        Box(
            modifier = modifier
                .fillMaxWidth()
        ) {
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                },
                modifier = modifier
                    .fillMaxWidth()
            ) {
                OutlinedTextField(
                    shape = MaterialTheme.shapes.medium,
                    value = armyDetails.factionName,
                    textStyle = MaterialTheme.typography.displayMedium.copy(
                        fontSize = 17.sp
                    ),
                    onValueChange = {
                        onArmyValueChange(armyDetails.copy(factionName = it, factionDrawablePrefix = it.lowercase().replace(" ", "").replace("'", "")))
                    },
                    label = {
                        Text(
                            text = stringResource(R.string.new_army_creator_label_selected_faction),
                            style = MaterialTheme.typography.displaySmall
                        )
                    },
                    readOnly = true,
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.padding_tiny))
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = modifier
                        .background(colorResource(R.color.unit_card_black))
                        .width(220.dp)
                ) {
                    allFactions.forEach { factionName ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = factionName,
                                    style = MaterialTheme.typography.displayMedium,
                                    textAlign = TextAlign.Center,
                                    modifier = modifier
                                        .fillMaxWidth()
                                )
                            },
                            onClick = {
                                onArmyValueChange(armyDetails.copy(factionName = factionName, factionDrawablePrefix = factionName.lowercase().replace(" ", "").replace("'", "")))
                                expanded = false
                            },
                        )
                    }
                }
            }
        }
        OutlinedTextField(
            shape = MaterialTheme.shapes.medium,
            value = armyDetails.armyName,
            textStyle = MaterialTheme.typography.displayMedium.copy(
                fontSize = 17.sp
            ),
            onValueChange = {
                onArmyValueChange(armyDetails.copy(armyName = it))
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            label = {
                Text(
                    text = stringResource(R.string.new_army_creator_label_army_name),
                    style = MaterialTheme.typography.displaySmall
                )
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.padding_tiny))
        )
        OutlinedTextField(
            shape = MaterialTheme.shapes.medium,
            value = armyDetails.maxPoints,
            textStyle = MaterialTheme.typography.displayMedium.copy(
                fontSize = 17.sp
            ),
            onValueChange = {
                if (it.isDigitsOnly())
                    onArmyValueChange(armyDetails.copy(maxPoints = it))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            label = {
                Text(
                    text = stringResource(R.string.new_army_creator_label_max_points),
                    style = MaterialTheme.typography.displaySmall
                )
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.padding_tiny))
        )
    }
}


val factionList = arrayOf(
    "Adepta Sororitas",
    "Adeptus Custodes",
    "Adeptus Mechanicus",
    "Aeldari",
    "Astra Militarum",
    "Black Templars",
    "Blood Angels",
    "Chaos Daemons",
    "Chaos Knights",
    "Chaos Space Marines",
    "Dark Angels",
    "Death Guard",
    "Deathwatch",
    "Drukhari",
    "Genestealer Cults",
    "Grey Knights",
    "Imperial Agents",
    "Imperial Knights",
    "Leagues Of Votann",
    "Necrons",
    "Orks",
    "Space Marines",
    "Space Wolves",
    "T'au Empire",
    "Thousand Sons",
    "Tyranids",
    "World Eaters"
)