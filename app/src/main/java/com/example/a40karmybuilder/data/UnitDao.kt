package com.example.a40karmybuilder.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RawQuery
import androidx.room.Update
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import kotlinx.coroutines.flow.Flow

@Dao
interface UnitDao {
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insert(item: Unit)
//
//    @Update
//    suspend fun update(item: Unit)
//
//    @Delete
//    suspend fun delete(item: Unit)

//    @Query("SELECT * from unit_faction WHERE id = :id")
//    fun getItem(unit_faction: String, id: Int): Flow<Faction>
//
//    @Query("SELECT * from factions ORDER BY id ASC")
//    fun getAllItems(): Flow<List<Faction>>

    // Cannot have dynamically defined arguments for @Query annotations. Must be written like this.
    @RawQuery(observedEntities = [
        AdeptaSororitasUnit::class,
        AdeptusCustodesUnit::class,
        AdeptusMechanicusUnit::class,
        AeldariUnit::class,
        AstraMilitarumUnit::class,
        BlackTemplarsUnit::class,
        BloodAngelsUnit::class,
        ChaosDaemonsUnit::class,
        ChaosKnightsUnit::class,
        ChaosSpaceMarinesUnit::class,
        DarkAngelsUnit::class,
        DeathGuardUnit::class,
        DeathwatchUnit::class,
        DrukhariUnit::class,
        GenestealerCultsUnit::class,
        GreyKnightsUnit::class,
        ImperialAgentsUnit::class,
        ImperialKnightsUnit::class,
        LeaguesOfVotannUnit::class,
        NecronsUnit::class,
        OrksUnit::class,
        SpaceMarinesUnit::class,
        SpaceWolvesUnit::class,
        TauUnit::class,
        ThousandSonsUnit::class,
        TyranidsUnit::class,
        WorldEatersUnit::class
    ])
    fun itemQuery(query: SupportSQLiteQuery): Flow<Unit>

    @RawQuery(observedEntities = [
        AdeptaSororitasUnit::class,
        AdeptusCustodesUnit::class,
        AdeptusMechanicusUnit::class,
        AeldariUnit::class,
        AstraMilitarumUnit::class,
        BlackTemplarsUnit::class,
        BloodAngelsUnit::class,
        ChaosDaemonsUnit::class,
        ChaosKnightsUnit::class,
        ChaosSpaceMarinesUnit::class,
        DarkAngelsUnit::class,
        DeathGuardUnit::class,
        DeathwatchUnit::class,
        DrukhariUnit::class,
        GenestealerCultsUnit::class,
        GreyKnightsUnit::class,
        ImperialAgentsUnit::class,
        ImperialKnightsUnit::class,
        LeaguesOfVotannUnit::class,
        NecronsUnit::class,
        OrksUnit::class,
        SpaceMarinesUnit::class,
        SpaceWolvesUnit::class,
        TauUnit::class,
        ThousandSonsUnit::class,
        TyranidsUnit::class,
        WorldEatersUnit::class
    ])
    fun allItemsQuery(query: SupportSQLiteQuery): Flow<List<Unit>>

    suspend fun insert(tableName: String, item: Unit) {
        val simpleSqliteQuery = SimpleSQLiteQuery("INSERT INTO $tableName (item) VALUES (?)", arrayOf(item))
        this.itemQuery(simpleSqliteQuery)
    }

    suspend fun update(tableName: String, item: Unit) {
        val simpleSqliteQuery = SimpleSQLiteQuery("UPDATE $tableName SET item = ?", arrayOf(item))
        this.itemQuery(simpleSqliteQuery)
    }

    suspend fun delete(tableName: String, item: Unit) {
        val simpleSqliteQuery = SimpleSQLiteQuery("DELETE FROM $tableName WHERE item = ?", arrayOf(item))
        this.itemQuery(simpleSqliteQuery)
    }

    fun getItem(tableName: String, id: Int): Flow<Unit> {
        val simpleSqliteQuery =  SimpleSQLiteQuery("SELECT * from $tableName WHERE id = :id")
        return this.itemQuery(simpleSqliteQuery)
    }

    fun getAllItems(tableName: String): Flow<List<Unit>> {
        val simpleSqliteQuery =  SimpleSQLiteQuery("SELECT * from $tableName ORDER BY id ASC")
        return this.allItemsQuery(simpleSqliteQuery)
    }
}