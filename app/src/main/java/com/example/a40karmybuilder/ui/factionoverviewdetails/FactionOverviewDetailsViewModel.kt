package com.example.a40karmybuilder.ui.factionoverviewdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.a40karmybuilder.data.ArmiesRepository
import com.example.a40karmybuilder.ui.factionoverviewlist.FactionOverviewInfo

class FactionOverviewDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val armiesRepository: ArmiesRepository,
) : ViewModel() {

}

data class FactionOverviewDetailsUiState(
    val available: Boolean = true,
    val faction: FactionOverviewInfo
)