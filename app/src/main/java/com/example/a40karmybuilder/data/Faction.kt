package com.example.a40karmybuilder.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "factions")
data class Faction(
    @PrimaryKey val id: Int = 0,
    @NonNull @ColumnInfo(name = "drawable_prefix") val drawablePrefix: String,
    @NonNull @ColumnInfo(name = "name") val name: String,
    @NonNull @ColumnInfo(name = "description") val description: String,
    @NonNull @ColumnInfo(name = "quote") val quote: String,
    @NonNull @ColumnInfo(name = "quote_source") val quoteSource: String,
    @NonNull @ColumnInfo(name = "games_workshop_url") val gamesWorkshopUrl: String,
    @NonNull @ColumnInfo(name = "warhammer_wiki_url") val warhammerWikiUrl: String,
    @NonNull @ColumnInfo(name = "wahapedia_url") val wahapediaUrl: String
//    @DrawableRes @ColumnInfo(name = "banner") val bannerResourceId: Int,
//    @DrawableRes @ColumnInfo(name = "logo") val logoResourceId: Int,
//    @DrawableRes @ColumnInfo(name = "symbol") val symbolResourceId: Int,
//    @StringRes @ColumnInfo(name = "name") val nameResourceId: Int,
//    @StringRes @ColumnInfo(name = "description") val descriptionResourceId: Int,
//    @StringRes @ColumnInfo(name = "quote") val quoteResourceId: Int,
//    @StringRes @ColumnInfo(name = "quote_source") val quoteSourceResourceId: Int
)
