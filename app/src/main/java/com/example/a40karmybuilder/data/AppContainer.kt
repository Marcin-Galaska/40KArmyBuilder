package com.example.a40karmybuilder.data

import android.content.Context

interface AppContainer {
    val armiesRepository: ArmiesRepository
    val factionsRepository : FactionsRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val armiesRepository: ArmiesRepository by lazy {
        OfflineArmiesRepository(ArmyDatabase.getDatabase(context).armyDao())
    }
    override val factionsRepository: FactionsRepository by lazy {
        OfflineFactionsRepository(FactionDatabase.getDatabase(context).factionDao())
    }
}