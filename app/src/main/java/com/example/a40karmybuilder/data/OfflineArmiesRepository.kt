package com.example.a40karmybuilder.data

import kotlinx.coroutines.flow.Flow

class OfflineArmiesRepository(private val armyDao: ArmyDao) : ArmiesRepository {
    override fun getAllItemsStream(): Flow<List<Army>> = armyDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Army?> = armyDao.getItem(id)

    override suspend fun insertItem(army: Army) = armyDao.insert(army)

    override suspend fun deleteItem(army: Army) = armyDao.delete(army)

    override suspend fun updateItem(army: Army) = armyDao.update(army)
}