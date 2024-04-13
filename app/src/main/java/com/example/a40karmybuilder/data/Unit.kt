package com.example.a40karmybuilder.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "unspecified")
open class Unit(
    @PrimaryKey @ColumnInfo(name = "necessary_evil") open var necessaryEvil: Int = 0,   //Required @PrimaryKey field
    @Ignore open val id: Int = 0,
    @Ignore open val name: String = "unspecified",
    @Ignore open val m: String = "NaN",
    @Ignore open val t: String = "NaN",
    @Ignore open val sv: String = "NaN",
    @Ignore open val w: String = "NaN",
    @Ignore open val ld: String = "NaN",
    @Ignore open val oc: String = "NaN",
    @Ignore open val invulnerableSave: String? = null,
    @Ignore open val pointsCost: Int = 0,
    @Ignore open val composition: String = "unspecified",
    @Ignore open val keywords: String = "unspecified",
    @Ignore open val description: String = "unspecified"
) {
    constructor(): this(0, 0, "unspecified", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", "NaN", 0, "unspecified", "unspecified", "unspecified")
}

@Entity(tableName = "adepta-sororitas", ignoredColumns = ["necessary_evil"])
data class AdeptaSororitasUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "adeptus-custodes", ignoredColumns = ["necessary_evil"])
data class AdeptusCustodesUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "adeptus-mechanicus", ignoredColumns = ["necessary_evil"])
data class AdeptusMechanicusUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "aeldari", ignoredColumns = ["necessary_evil"])
data class AeldariUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "astra-militarum", ignoredColumns = ["necessary_evil"])
data class AstraMilitarumUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "black-templars", ignoredColumns = ["necessary_evil"])
data class BlackTemplarsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "blood-angels", ignoredColumns = ["necessary_evil"])
data class BloodAngelsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "chaos-daemons", ignoredColumns = ["necessary_evil"])
data class ChaosDaemonsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "chaos-knights", ignoredColumns = ["necessary_evil"])
data class ChaosKnightsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "chaos-space-marines", ignoredColumns = ["necessary_evil"])
data class ChaosSpaceMarinesUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "dark-angels", ignoredColumns = ["necessary_evil"])
data class DarkAngelsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "death-guard", ignoredColumns = ["necessary_evil"])
data class DeathGuardUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "deathwatch", ignoredColumns = ["necessary_evil"])
data class DeathwatchUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "drukhari", ignoredColumns = ["necessary_evil"])
data class DrukhariUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "genestealer-cults", ignoredColumns = ["necessary_evil"])
data class GenestealerCultsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "grey-knights", ignoredColumns = ["necessary_evil"])
data class GreyKnightsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "imperial-agents", ignoredColumns = ["necessary_evil"])
data class ImperialAgentsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "imperial-knights", ignoredColumns = ["necessary_evil"])
data class ImperialKnightsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "leagues-of-votann", ignoredColumns = ["necessary_evil"])
data class LeaguesOfVotannUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "necrons", ignoredColumns = ["necessary_evil"])
data class NecronsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "orks", ignoredColumns = ["necessary_evil"])
data class OrksUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "space-marines", ignoredColumns = ["necessary_evil"])
data class SpaceMarinesUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "space-wolves", ignoredColumns = ["necessary_evil"])
data class SpaceWolvesUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "tau", ignoredColumns = ["necessary_evil"])
data class TauUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "thousand-sons", ignoredColumns = ["necessary_evil"])
data class ThousandSonsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "tyranids", ignoredColumns = ["necessary_evil"])
data class TyranidsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()

@Entity(tableName = "world-eaters", ignoredColumns = ["necessary_evil"])
data class WorldEatersUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String = "unspecified",
    @ColumnInfo(name = "m") override val m: String = "NaN",
    @ColumnInfo(name = "t") override val t: String = "NaN",
    @ColumnInfo(name = "sv") override val sv: String = "NaN",
    @ColumnInfo(name = "w") override val w: String = "NaN",
    @ColumnInfo(name = "ld") override val ld: String = "NaN",
    @ColumnInfo(name = "oc") override val oc: String = "NaN",
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String? = null,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int = 0,
    @ColumnInfo(name = "composition") override val composition: String = "unspecified",
    @ColumnInfo(name = "keywords") override val keywords: String = "unspecified",
    @ColumnInfo(name = "description") override val description: String = "unspecified"
) : Unit()