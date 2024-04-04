package com.example.a40karmybuilder.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Army::class], version = 1, exportSchema = false)
abstract class ArmyDatabase : RoomDatabase() {
    abstract fun armyDao(): ArmyDao

    companion object {
        @Volatile
        private var Instance: ArmyDatabase? = null

        fun getDatabase(context: Context): ArmyDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    ArmyDatabase::class.java,
                    "army_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}