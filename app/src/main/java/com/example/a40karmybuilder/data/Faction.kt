package com.example.a40karmybuilder.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "factions")
data class Faction(
    @PrimaryKey val id: Int = 0,
    @ColumnInfo(name = "drawable_prefix") val drawablePrefix: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "quote") val quote: String,
    @ColumnInfo(name = "quote_source") val quoteSource: String,
    @ColumnInfo(name = "games_workshop_url") val gamesWorkshopUrl: String,
    @ColumnInfo(name = "warhammer_wiki_url") val warhammerWikiUrl: String,
    @ColumnInfo(name = "wahapedia_url") val wahapediaUrl: String
)


