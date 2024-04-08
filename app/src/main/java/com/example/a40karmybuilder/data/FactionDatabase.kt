package com.example.a40karmybuilder.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = arrayOf(Faction::class),
    version = 1,
    exportSchema = false
)
abstract class FactionDatabase : RoomDatabase() {
    abstract fun factionDao(): FactionDao

    companion object {
        @Volatile
        private var Instance: FactionDatabase? = null

        fun getDatabase(context: Context): FactionDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    FactionDatabase::class.java,
                    "faction_database"
                )
                    .createFromAsset("database/factions.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        Instance = it
                    }
            }
        }
    }
}