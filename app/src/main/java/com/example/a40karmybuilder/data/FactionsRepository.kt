package com.example.a40karmybuilder.data

import kotlinx.coroutines.flow.Flow

interface FactionsRepository {
    fun getAllItemsStream(): Flow<List<Faction>>

    fun getItemStream(id: Int): Flow<Faction?>

    suspend fun insertItem(faction: Faction)

    suspend fun deleteItem(faction: Faction)

    suspend fun updateItem(faction: Faction)
}