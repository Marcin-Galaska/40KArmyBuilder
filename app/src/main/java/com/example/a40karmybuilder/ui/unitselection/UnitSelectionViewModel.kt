package com.example.a40karmybuilder.ui.unitselection

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.a40karmybuilder.a40KArmyBuilderApplication
import com.example.a40karmybuilder.data.ArmiesRepository
import com.example.a40karmybuilder.data.Army
import com.example.a40karmybuilder.data.Unit
import com.example.a40karmybuilder.data.UnitDao
import kotlinx.coroutines.flow.Flow

class UnitSelectionViewModel(
    private val unitDao: UnitDao,
    private val armiesRepository: ArmiesRepository
): ViewModel() {
    fun getAllUnits(tableName: String): Flow<List<Unit>> = unitDao.getAllItems(tableName)
    fun getUnit(tableName: String, id: Int): Flow<Unit> = unitDao.getItem(tableName, id)

    suspend fun addUnit(unit: Unit, context: Context, onFailMessage: String) {
        if(
            currentArmy.currentPoints + unit.pointsCost > currentArmy.maxPoints ||
            (
                unit.composition.contains("EPIC HERO", ignoreCase = true) &&
                currentArmy.units.find{ it.name == unit.name } != null
            )
        ) {
            Toast.makeText(context, onFailMessage, Toast.LENGTH_SHORT).show()
            return
        }

        val currentArmyPoints = currentArmy.currentPoints
        val mutableUnitsList = currentArmy.units.toMutableList()
        mutableUnitsList.add(unit)

        currentArmy = currentArmy.copy(
            currentPoints = currentArmyPoints + unit.pointsCost,
            units = mutableUnitsList.toList()
        )

        armiesRepository.updateItem(currentArmy)
    }

    suspend fun removeUnit(unit: Unit, context: Context, onFailMessage: String) {
        if(
            currentArmy.units.find{ it.name == unit.name } == null
        ) {
            Toast.makeText(context, onFailMessage, Toast.LENGTH_SHORT).show()
            return
        }

        val currentArmyPoints = currentArmy.currentPoints
        val mutableUnitsList = currentArmy.units.toMutableList()
        mutableUnitsList.removeAt(
            mutableUnitsList.indexOfFirst { it.name == unit.name }
        )

        currentArmy = currentArmy.copy(
            currentPoints = currentArmyPoints - unit.pointsCost,
            units = mutableUnitsList.toList()
        )

        armiesRepository.updateItem(currentArmy)
    }

    companion object {
        var currentArmy: Army = Army(
            id = 0,
            factionDrawablePrefix = "adeptusmechanicus",
            factionName = "Adeptus Mechanicus",
            armyName = "Unspecified",
            maxPoints = 2000,
            currentPoints = 0,
            units = emptyList()
        )
    }
}