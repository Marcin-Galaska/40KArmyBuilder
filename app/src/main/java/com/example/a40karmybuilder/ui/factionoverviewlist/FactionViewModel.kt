package com.example.a40karmybuilder.ui.factionoverviewlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.a40karmybuilder.a40KArmyBuilderApplication
import com.example.a40karmybuilder.data.Faction
import com.example.a40karmybuilder.data.FactionDao
import kotlinx.coroutines.flow.Flow

class FactionViewModel(
    private val factionDao: FactionDao
): ViewModel() {
    fun getAllFactions(): Flow<List<Faction>> = factionDao.getAllItems()
    fun getFaction(id: Int): Flow<Faction> = factionDao.getItem(id)

    companion object {
        var selectedFactionId: Int = 0
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as a40KArmyBuilderApplication)
                FactionViewModel(application.factionDatabase.factionDao())
            }
        }
    }
}