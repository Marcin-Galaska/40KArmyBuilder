package com.example.a40karmybuilder.data

import kotlinx.coroutines.flow.Flow

class OfflineArmiesRepository(private val itemDao: ArmyDao) : ArmiesRepository {
    override fun getAllArmiesStream(): Flow<List<Army>> = itemDao.getAllItems()

    override fun getArmyStream(id: Int): Flow<Army?> = itemDao.getItem(id)

    override suspend fun insertArmy(army: Army) = itemDao.insert(army)

    override suspend fun deleteArmy(army: Army) = itemDao.delete(army)

    override suspend fun updateArmy(army: Army) = itemDao.update(army)
}