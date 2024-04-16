package com.example.a40karmybuilder.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class UnitConverters {
    @TypeConverter
    fun fromList(value : List<Unit>) = Json.encodeToString(value)

    @TypeConverter
    fun toList(value: String) = Json.decodeFromString<List<Unit>>(value)
}

@Entity(tableName = "armies")
@TypeConverters(UnitConverters::class)
data class Army(
    @PrimaryKey val id: Int = 0,
    @ColumnInfo(name = "faction_drawable_prefix") val factionDrawablePrefix: String,
    @ColumnInfo(name = "faction_name") val factionName: String,
    @ColumnInfo(name = "army_name") val armyName: String,
    @ColumnInfo(name = "max_points") val maxPoints: Int,
    @ColumnInfo(name = "current_points") val currentPoints: Int,
    @ColumnInfo(name = "units") val units: List<Unit>
)
