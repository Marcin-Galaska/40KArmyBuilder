package com.example.a40karmybuilder.ui.unitselection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.a40karmybuilder.a40KArmyBuilderApplication
import com.example.a40karmybuilder.data.Unit
import com.example.a40karmybuilder.data.UnitDao
import kotlinx.coroutines.flow.Flow

class UnitViewModel(
    private val unitDao: UnitDao
): ViewModel() {
    fun getAllUnits(tableName: String): Flow<List<Unit>> = unitDao.getAllItems(tableName)
    fun getUnit(tableName: String, id: Int): Flow<Unit> = unitDao.getItem(tableName, id)

    companion object {
        var selectedUnitsFactionName: String = "leagues_of_votann"
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as a40KArmyBuilderApplication)
                UnitViewModel(application.unitDatabase.unitDao())
            }
        }
    }
}