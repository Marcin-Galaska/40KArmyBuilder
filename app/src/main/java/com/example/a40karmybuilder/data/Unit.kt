package com.example.a40karmybuilder.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "unspecified")
open class Unit(
    @PrimaryKey @ColumnInfo(name = "necessary_evil") open var necessaryEvil: Int,   //Required @PrimaryKey field
    @ColumnInfo(name = "id") open val id: Int,
    @ColumnInfo(name = "name") open val name: String,
    @ColumnInfo(name = "m") open val m: String,
    @ColumnInfo(name = "t") open val t: String,
    @ColumnInfo(name = "sv") open val sv: String,
    @ColumnInfo(name = "w") open val w: String,
    @ColumnInfo(name = "ld") open val ld: String,
    @ColumnInfo(name = "oc") open val oc: String,
    @ColumnInfo(name = "invulnerable_save") open val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") open val pointsCost: Int,
    @ColumnInfo(name = "composition") open val composition: String,
    @ColumnInfo(name = "keywords") open val keywords: String,
    @ColumnInfo(name = "description") open val description: String
)

@Entity(tableName = "adepta_sororitas", ignoredColumns = ["necessary_evil"])
data class AdeptaSororitasUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)

@Entity(tableName = "adeptus_custodes", ignoredColumns = ["necessary_evil"])
data class AdeptusCustodesUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)

@Entity(tableName = "adeptus_mechanicus", ignoredColumns = ["necessary_evil"])
data class AdeptusMechanicusUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)

@Entity(tableName = "aeldari", ignoredColumns = ["necessary_evil"])
data class AeldariUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)

@Entity(tableName = "astra_militarum", ignoredColumns = ["necessary_evil"])
data class AstraMilitarumUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "black_templars", ignoredColumns = ["necessary_evil"])
data class BlackTemplarsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "blood_angels", ignoredColumns = ["necessary_evil"])
data class BloodAngelsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "chaos_daemons", ignoredColumns = ["necessary_evil"])
data class ChaosDaemonsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "chaos_knights", ignoredColumns = ["necessary_evil"])
data class ChaosKnightsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "chaos_space_marines", ignoredColumns = ["necessary_evil"])
data class ChaosSpaceMarinesUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "dark_angels", ignoredColumns = ["necessary_evil"])
data class DarkAngelsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "death_guard", ignoredColumns = ["necessary_evil"])
data class DeathGuardUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "deathwatch", ignoredColumns = ["necessary_evil"])
data class DeathwatchUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "drukhari", ignoredColumns = ["necessary_evil"])
data class DrukhariUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "genestealer_cults", ignoredColumns = ["necessary_evil"])
data class GenestealerCultsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "grey_knights", ignoredColumns = ["necessary_evil"])
data class GreyKnightsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "imperial_agents", ignoredColumns = ["necessary_evil"])
data class ImperialAgentsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "imperial_knights", ignoredColumns = ["necessary_evil"])
data class ImperialKnightsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "leagues_of_votann", ignoredColumns = ["necessary_evil"])
data class LeaguesOfVotannUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "necrons", ignoredColumns = ["necessary_evil"])
data class NecronsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "orks", ignoredColumns = ["necessary_evil"])
data class OrksUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "space_marines", ignoredColumns = ["necessary_evil"])
data class SpaceMarinesUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "space_wolves", ignoredColumns = ["necessary_evil"])
data class SpaceWolvesUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "t_au_empire", ignoredColumns = ["necessary_evil"])
data class TauUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "thousand_sons", ignoredColumns = ["necessary_evil"])
data class ThousandSonsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "tyranids", ignoredColumns = ["necessary_evil"])
data class TyranidsUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)


@Entity(tableName = "world_eaters", ignoredColumns = ["necessary_evil"])
data class WorldEatersUnit(
    @PrimaryKey override val id: Int = 0,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "m") override val m: String,
    @ColumnInfo(name = "t") override val t: String,
    @ColumnInfo(name = "sv") override val sv: String,
    @ColumnInfo(name = "w") override val w: String,
    @ColumnInfo(name = "ld") override val ld: String,
    @ColumnInfo(name = "oc") override val oc: String,
    @ColumnInfo(name = "invulnerable_save") override val invulnerableSave: String?,
    @ColumnInfo(name = "points_cost") override val pointsCost: Int,
    @ColumnInfo(name = "composition") override val composition: String,
    @ColumnInfo(name = "keywords") override val keywords: String,
    @ColumnInfo(name = "description") override val description: String
) : Unit(id = id, name = name, m = m, t = t, sv = sv, w = w, ld = ld, oc = oc, invulnerableSave = invulnerableSave, pointsCost = pointsCost, composition = composition, keywords = keywords, description = description, necessaryEvil = 0)
