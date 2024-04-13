package com.example.a40karmybuilder.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
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
    ],
    version = 1,
    exportSchema = false
)
abstract class UnitDatabase : RoomDatabase() {
    abstract fun unitDao(): UnitDao

    companion object {
        @Volatile
        private var Instance: UnitDatabase? = null

        fun getDatabase(context: Context): UnitDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    UnitDatabase::class.java,
                    "unit_database"
                )
                    .createFromAsset("database/units.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        Instance = it
                    }
            }
        }
    }
}