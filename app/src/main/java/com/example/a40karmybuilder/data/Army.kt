package com.example.a40karmybuilder.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "armies")
data class Army(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val faction: String,
    val name: String,
    val max_points: Double,
    val current_points: Int
)
