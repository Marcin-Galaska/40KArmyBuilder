package com.example.a40karmybuilder

import android.app.Application
import com.example.a40karmybuilder.data.AppContainer
import com.example.a40karmybuilder.data.AppDataContainer
import com.example.a40karmybuilder.data.ArmyDatabase
import com.example.a40karmybuilder.data.FactionDatabase
import com.example.a40karmybuilder.data.UnitDatabase

class a40KArmyBuilderApplication : Application() {
    val armyDatabase: ArmyDatabase by lazy { ArmyDatabase.getDatabase(this) }
    val factionDatabase: FactionDatabase by lazy { FactionDatabase.getDatabase(this) }
    val unitDatabase: UnitDatabase by lazy { UnitDatabase.getDatabase(this) }
    // To co poniżej pewnie zbędne

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}