package com.example.a40karmybuilder.data

import kotlinx.coroutines.flow.Flow

class OfflineUnitsRepository(private val unitDao: UnitDao) : UnitsRepository {
    override fun getAllItemsStream(tableName: String): Flow<List<Unit>> = unitDao.getAllItems(tableName)

    override fun getItemStream(tableName: String, id: Int): Flow<Unit?> = unitDao.getItem(tableName, id)

    override suspend fun insertItem(tableName: String, item: Unit) = unitDao.insert(tableName, item)

    override suspend fun deleteItem(tableName: String, item: Unit) = unitDao.delete(tableName, item)

    override suspend fun updateItem(tableName: String, item: Unit) = unitDao.update(tableName, item)
}