package com.example.a40karmybuilder.data

import kotlinx.coroutines.flow.Flow

interface ArmiesRepository {
    fun getAllArmiesStream(): Flow<List<Army>>

    fun getArmyStream(id: Int): Flow<Army?>

    suspend fun insertArmy(army: Army)

    suspend fun deleteArmy(army: Army)

    suspend fun updateArmy(army: Army)
}