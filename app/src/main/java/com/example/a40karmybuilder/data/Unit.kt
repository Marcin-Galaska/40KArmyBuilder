package com.example.a40karmybuilder.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/*
    * UNIT CATEGORIES:
    * 1 - Character
    * 2 - Battleline
    * 3 - Dedicated Transport
    * 4 - Other
*/

open class Unit(
    @Ignore open val id: Int = 0,
    @Ignore open val drawablePrefix: String = "unspecified",
    @Ignore open val wahapediaArmyUrl: String = "unspecified",
    @Ignore open val name: String = "unspecified",
    @Ignore open val pointsCost: Int = 0,
    @Ignore open val movement: Int = 0,
    @Ignore open val toughness: Int = 0,
    @Ignore open val armourSave: Int = 0,
    @Ignore open val wounds: Int = 0,
    @Ignore open val leadership: Int = 0,
    @Ignore open val objectiveControl: Int = 0,
    @Ignore open val unitComposition: String = "unspecified",
    @Ignore open val unitEquipment: String = "unspecified",
    @Ignore open val keywords: String = "unspecified",
    @Ignore open val isEpicHero: Int = 0,
    @Ignore open val category: Int = 0,
    @Ignore open val customWahapediaUriUnit: String? = null
)

@Entity(tableName = "adepta_sororitas_units")
data class AdeptaSororitasUnit(
    @PrimaryKey override val id: Int = 0,
    @NonNull @ColumnInfo(name = "drawable_prefix") override val drawablePrefix: String = "adeptasororitas",
    @NonNull @ColumnInfo(name = "wahapedia_army_url") override val wahapediaArmyUrl: String = "https://wahapedia.ru/wh40k10ed/factions/adeptta-sororitas/",
    @NonNull @ColumnInfo(name = "name") override val name: String = "Unspecified Adepta Sororitas Unit",
    @NonNull @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @NonNull @ColumnInfo(name = "movement") override val movement: Int = 0,
    @NonNull @ColumnInfo(name = "toughness") override val toughness: Int = 0,
    @NonNull @ColumnInfo(name = "armour_save") override val armourSave: Int = 0,
    @NonNull @ColumnInfo(name = "wounds") override val wounds: Int = 0,
    @NonNull @ColumnInfo(name = "leadership") override val leadership: Int = 0,
    @NonNull @ColumnInfo(name = "objective_control") override val objectiveControl: Int = 0,
    @NonNull @ColumnInfo(name = "unit_composition") override val unitComposition: String = "0 Unspecified Units",
    @NonNull @ColumnInfo(name = "unit_equipment") override val unitEquipment: String = "The Unspecified Unit model is equipped with: NONE",
    @NonNull @ColumnInfo(name = "keywords") override val keywords: String = "KEYWORDS: NONE",
    @NonNull @ColumnInfo(name = "is_epic_hero") override val isEpicHero: Int = 0,
    @NonNull @ColumnInfo(name = "category") override val category: Int = 4,
    @ColumnInfo(name = "custom_wahapedia_uri_unit") override val customWahapediaUriUnit: String? = null
) : Unit()

@Entity(tableName = "adeptus_custodes_units")
data class AdeptusCustodesUnit(
    @PrimaryKey override val id: Int = 0,
    @NonNull @ColumnInfo(name = "drawable_prefix") override val drawablePrefix: String = "adeptuscustodes",
    @NonNull @ColumnInfo(name = "wahapedia_army_url") override val wahapediaArmyUrl: String = "https://wahapedia.ru/wh40k10ed/factions/adeptus-custodes/",
    @NonNull @ColumnInfo(name = "name") override val name: String = "Unspecified Adeptus Custodes Unit",
    @NonNull @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @NonNull @ColumnInfo(name = "movement") override val movement: Int = 0,
    @NonNull @ColumnInfo(name = "toughness") override val toughness: Int = 0,
    @NonNull @ColumnInfo(name = "armour_save") override val armourSave: Int = 0,
    @NonNull @ColumnInfo(name = "wounds") override val wounds: Int = 0,
    @NonNull @ColumnInfo(name = "leadership") override val leadership: Int = 0,
    @NonNull @ColumnInfo(name = "objective_control") override val objectiveControl: Int = 0,
    @NonNull @ColumnInfo(name = "unit_composition") override val unitComposition: String = "0 Unspecified Units",
    @NonNull @ColumnInfo(name = "unit_equipment") override val unitEquipment: String = "The Unspecified Unit model is equipped with: NONE",
    @NonNull @ColumnInfo(name = "keywords") override val keywords: String = "KEYWORDS: NONE",
    @NonNull @ColumnInfo(name = "is_epic_hero") override val isEpicHero: Int = 0,
    @NonNull @ColumnInfo(name = "category") override val category: Int = 4,
    @ColumnInfo(name = "custom_wahapedia_uri_unit") override val customWahapediaUriUnit: String? = null
) : Unit()

@Entity(tableName = "adeptus_mechanicus_units")
data class AdeptusMechanicusUnit(
    @PrimaryKey override val id: Int = 0,
    @NonNull @ColumnInfo(name = "drawable_prefix") override val drawablePrefix: String = "adeptusmechanicus",
    @NonNull @ColumnInfo(name = "wahapedia_army_url") override val wahapediaArmyUrl: String = "https://wahapedia.ru/wh40k10ed/factions/adeptus-mechanicus/",
    @NonNull @ColumnInfo(name = "name") override val name: String = "Unspecified Adeptus Mechanicus Unit",
    @NonNull @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @NonNull @ColumnInfo(name = "movement") override val movement: Int = 0,
    @NonNull @ColumnInfo(name = "toughness") override val toughness: Int = 0,
    @NonNull @ColumnInfo(name = "armour_save") override val armourSave: Int = 0,
    @NonNull @ColumnInfo(name = "wounds") override val wounds: Int = 0,
    @NonNull @ColumnInfo(name = "leadership") override val leadership: Int = 0,
    @NonNull @ColumnInfo(name = "objective_control") override val objectiveControl: Int = 0,
    @NonNull @ColumnInfo(name = "unit_composition") override val unitComposition: String = "0 Unspecified Units",
    @NonNull @ColumnInfo(name = "unit_equipment") override val unitEquipment: String = "The Unspecified Unit model is equipped with: NONE",
    @NonNull @ColumnInfo(name = "keywords") override val keywords: String = "KEYWORDS: NONE",
    @NonNull @ColumnInfo(name = "is_epic_hero") override val isEpicHero: Int = 0,
    @NonNull @ColumnInfo(name = "category") override val category: Int = 4,
    @ColumnInfo(name = "custom_wahapedia_uri_unit") override val customWahapediaUriUnit: String? = null
) : Unit()

open class BaseUnit(
    open val id: String,
    open var name: String,
    open var creator: String,
    open var dateOfLastEdit: String,
    open var contributors: List<String>,
    open var color: Int,
    open var offline: Boolean
)

@Entity
data class ChildUnit(
    @PrimaryKey(autoGenerate = false)
    override val id: String = "",
    override var name: String = "",
    override var creator: String = "",
    override var dateOfLastEdit: String = "",
    override var contributors: List<String> = emptyList(),
    override var color: Int = 0,
    override var offline: Boolean = false
) : BaseUnit(id, name, creator, dateOfLastEdit, contributors, color, offline) {
    constructor() : this("", "", "", "", emptyList(), 0, false)
}