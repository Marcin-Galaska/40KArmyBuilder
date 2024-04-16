package com.example.a40karmybuilder.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ArmyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Army)

    @Update
    suspend fun update(item: Army)

    @Delete
    suspend fun delete(item: Army)

    @Query("SELECT * from armies WHERE id = :id")
    fun getItem(id: Int): Flow<Army>

    @Query("SELECT * from armies ORDER BY id ASC")
    fun getAllItems(): Flow<List<Army>>
}