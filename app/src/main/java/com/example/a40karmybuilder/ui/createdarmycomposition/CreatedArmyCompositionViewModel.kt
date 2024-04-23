package com.example.a40karmybuilder.ui.createdarmycomposition

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.a40karmybuilder.data.ArmiesRepository
import com.example.a40karmybuilder.data.Unit
import com.example.a40karmybuilder.ui.a40karmybuilderApplication
import com.example.a40karmybuilder.ui.newarmycreator.ArmyDetails
import com.example.a40karmybuilder.ui.newarmycreator.NewArmyCreatorViewModel
import com.example.a40karmybuilder.ui.newarmycreator.toArmy
import com.example.a40karmybuilder.ui.newarmycreator.toArmyDetails
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CreatedArmyCompositionViewModel(
    savedStateHandle: SavedStateHandle,
    private val armiesRepository: ArmiesRepository,
) : ViewModel() {
    private val armyId: Int = checkNotNull(savedStateHandle[CreatedArmyCompositionDestination.armyIdArg])

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val uiState: StateFlow<CreatedArmyCompositionUiState> =
        armiesRepository.getItemStream(armyId)
            .filterNotNull()
            .map {
                CreatedArmyCompositionUiState(armyDetails = it.toArmyDetails())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),

                // Required, without it the app crashes
                initialValue = CreatedArmyCompositionUiState(armyDetails = ArmyDetails(
                    id = 0,
                    factionDrawablePrefix = "adeptusmechanicus",
                    factionName = "Adeptus Mechanicus",
                    armyName = "Unspecified",
                    maxPoints = "2000",
                    currentPoints = 0,
                    units = emptyList()
                ))
            )

    fun deleteUnit(unitName: String) {
        viewModelScope.launch {
            val currentArmy = uiState.value.armyDetails.toArmy()
            val mutableUnitsList = currentArmy.units.toMutableList()
            val unwantedUnitIndex = mutableUnitsList.indexOfFirst{ it.name == unitName }

            if(unwantedUnitIndex > 0)
                mutableUnitsList.removeAt(unwantedUnitIndex)

            armiesRepository.updateItem(currentArmy.copy(units = mutableUnitsList.toList()))
        }
    }
}

data class CreatedArmyCompositionUiState(
    val armyDetails: ArmyDetails = ArmyDetails()
)