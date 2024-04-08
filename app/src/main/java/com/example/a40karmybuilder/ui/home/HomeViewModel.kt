package com.example.a40karmybuilder.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a40karmybuilder.data.Army
import com.example.a40karmybuilder.data.ArmiesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

// ViewModel to retrieve all items in the Room database.
class HomeViewModel(armiesRepository: ArmiesRepository): ViewModel() {
    val homeUiState: StateFlow<HomeUiState> =
        armiesRepository.getAllItemsStream().map {
            HomeUiState(it)
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}


// Ui State for HomeScreen
data class HomeUiState(
    val itemList: List<Army> = listOf()
)