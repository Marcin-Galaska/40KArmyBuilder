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
    armiesRepository: ArmiesRepository
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

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                CreatedArmiesListViewModel(a40karmybuilderApplication().container.armiesRepository)
            }
        }
    }
}

data class ArmiesUiState(
    val armyList: List<Army> = listOf()
)