package com.example.a40karmybuilder.data

import kotlinx.coroutines.flow.Flow

class OfflineFactionsRepository(private val factionDao: FactionDao) : FactionsRepository {
    override fun getAllItemsStream(): Flow<List<Faction>> = factionDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Faction?> = factionDao.getItem(id)

    override suspend fun insertItem(faction: Faction) = factionDao.insert(faction)

    override suspend fun deleteItem(faction: Faction) = factionDao.delete(faction)

    override suspend fun updateItem(faction: Faction) = factionDao.update(faction)
}