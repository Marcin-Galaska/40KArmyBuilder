package com.example.a40karmybuilder.ui.createdarmieslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.a40karmybuilder.data.ArmiesRepository
import com.example.a40karmybuilder.data.Army
import com.example.a40karmybuilder.ui.a40karmybuilderApplication
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class CreatedArmiesListViewModel(
    private val armiesRepository: ArmiesRepository
): ViewModel() {
    val armiesUiState: StateFlow<ArmiesUiState> =
        armiesRepository.getAllItemsStream().map {
            ArmiesUiState(it)
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ArmiesUiState()
            )

    suspend fun deleteArmy(id: Int) {
        armiesUiState.value.armyList.find {
            it.id == id
        }?.let {
            armiesRepository.deleteItem(it)
        }
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class ArmiesUiState(
    val armyList: List<Army> = listOf()
)