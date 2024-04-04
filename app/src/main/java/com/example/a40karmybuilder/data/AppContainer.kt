package com.example.a40karmybuilder.data

import android.content.Context

interface AppContainer {
    val armiesRepository: ArmiesRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val armiesRepository: ArmiesRepository by lazy {
        OfflineArmiesRepository(ArmyDatabase.getDatabase(context).armyDao())
    }
}