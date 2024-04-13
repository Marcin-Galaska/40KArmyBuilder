package com.example.a40karmybuilder.data

import kotlinx.coroutines.flow.Flow

interface UnitsRepository {
    fun getAllItemsStream(tableName: String): Flow<List<Unit>>

    fun getItemStream(tableName: String, id: Int): Flow<Unit?>

    suspend fun insertItem(tableName: String, item: Unit)

    suspend fun deleteItem(tableName: String, item: Unit)

    suspend fun updateItem(tableName: String, item: Unit)
}