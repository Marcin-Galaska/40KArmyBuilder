package com.example.a40karmybuilder.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FactionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Faction)

    @Update
    suspend fun update(item: Faction)

    @Delete
    suspend fun delete(item: Faction)

    @Query("SELECT * from factions WHERE id = :id")
    fun getItem(id: Int): Flow<Faction>

    @Query("SELECT * from factions ORDER BY id ASC")
    fun getAllItems(): Flow<List<Faction>>
}