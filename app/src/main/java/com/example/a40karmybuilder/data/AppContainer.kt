package com.example.a40karmybuilder.data

import android.content.Context

interface AppContainer {
    val armiesRepository: ArmiesRepository
    val factionsRepository : FactionsRepository
    val unitsRepository: UnitsRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val armiesRepository: ArmiesRepository by lazy {
        OfflineArmiesRepository(ArmyDatabase.getDatabase(context).armyDao())
    }
    override val factionsRepository: FactionsRepository by lazy {
        OfflineFactionsRepository(FactionDatabase.getDatabase(context).factionDao())
    }
    override val unitsRepository: UnitsRepository by lazy {
        OfflineUnitsRepository(UnitDatabase.getDatabase(context).unitDao())
    }
}