package com.example.a40karmybuilder.ui.newarmycreator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.a40karmybuilder.data.ArmiesRepository
import com.example.a40karmybuilder.data.Army
import com.example.a40karmybuilder.data.Unit
import com.example.a40karmybuilder.ui.a40karmybuilderApplication

class NewArmyCreatorViewModel(
    private val armiesRepository: ArmiesRepository
) : ViewModel() {
    var armyUiState by mutableStateOf(ArmyUiState())
        private set

    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                NewArmyCreatorViewModel(a40karmybuilderApplication().container.armiesRepository)
            }
        }
    }

    fun updateUiState(armyDetails: ArmyDetails) {
        armyUiState =
            ArmyUiState(
                armyDetails = armyDetails,
                isEntryValid = validateInput(armyDetails)
            )
    }

    private fun validateInput(uiState: ArmyDetails = armyUiState.armyDetails): Boolean {
        return with(uiState) {
            factionName.isNotBlank() && armyName.isNotBlank() && maxPoints.isNotBlank()
        }
    }

    suspend fun saveArmy() {
        if(validateInput()) {
            armiesRepository.insertItem(
                armyUiState.armyDetails.toArmy()
            )
        }
    }
}

data class ArmyUiState(
    val armyDetails: ArmyDetails = ArmyDetails(),
    val isEntryValid: Boolean = false
)

data class ArmyDetails(
    val id: Int = 0,
    val factionDrawablePrefix: String = "",
    val factionName: String = "",
    val armyName: String = "",
    val maxPoints: String = "",
    val currentPoints: Int = 0,
    val units: List<Unit> = emptyList()
)

fun ArmyDetails.toArmy(): Army = Army(
    id = id,
    factionDrawablePrefix = factionDrawablePrefix,
    factionName = factionName,
    armyName = armyName,
    maxPoints = maxPoints.toIntOrNull() ?: 0,
    currentPoints = currentPoints,
    units = units
)

fun Army.toArmyDetails(): ArmyDetails = ArmyDetails(
    id = id,
    factionDrawablePrefix = factionDrawablePrefix,
    factionName = factionName,
    armyName = armyName,
    maxPoints = maxPoints.toString(),
    currentPoints = currentPoints,
    units = units
)

fun Army.toArmyUiState(isEntryValid: Boolean = false): ArmyUiState = ArmyUiState(
    armyDetails = this.toArmyDetails(),
    isEntryValid = isEntryValid
)