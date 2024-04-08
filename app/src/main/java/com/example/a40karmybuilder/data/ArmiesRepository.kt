package com.example.a40karmybuilder.data

import kotlinx.coroutines.flow.Flow

interface ArmiesRepository {
    fun getAllItemsStream(): Flow<List<Army>>

    fun getItemStream(id: Int): Flow<Army?>

    suspend fun insertItem(army: Army)

    suspend fun deleteItem(army: Army)

    suspend fun updateItem(army: Army)
}