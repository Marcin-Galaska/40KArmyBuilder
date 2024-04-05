package com.example.a40karmybuilder.ui.factionoverviewlist

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a40karmybuilder.R

data class FactionOverviewInfo(
    @DrawableRes val bannerResourceId: Int,
    @DrawableRes val logoResourceId: Int,
    @DrawableRes val symbolResourceId: Int,
    @StringRes val nameResourceId: Int,
    @StringRes val descriptionResourceId: Int,
    @StringRes val quoteResourceId: Int,
    @StringRes val quoteSourceResourceId: Int
)

val factions = listOf(
    FactionOverviewInfo(
        R.drawable.adeptasororitas_banner, R.drawable.adeptasororitas_logo, R.drawable.adeptasororitas_symbol,
        R.string.adepta_sororitas_name, R.string.adepta_sororitas_desc, R.string.adepta_sororitas_quote, R.string.adepta_sororitas_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.adeptuscustodes_banner, R.drawable.adeptuscustodes_logo, R.drawable.adeptuscustodes_symbol,
        R.string.adeptus_custodes_name, R.string.adeptus_custodes_desc, R.string.adeptus_custodes_quote, R.string.adeptus_custodes_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.adeptusmechanicus_banner, R.drawable.adeptusmechanicus_logo, R.drawable.adeptusmechanicus_symbol,
        R.string.adeptus_mechanicus_name, R.string.adeptus_mechanicus_desc, R.string.adeptus_mechanicus_quote, R.string.adeptus_mechanicus_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.aeldari_banner, R.drawable.aeldari_logo, R.drawable.aeldari_symbol,
        R.string.aeldari_name, R.string.aeldari_desc, R.string.aeldari_quote, R.string.aeldari_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.astramilitarum_banner, R.drawable.astramilitarum_logo, R.drawable.astramilitarum_symbol,
        R.string.astra_militarum_name, R.string.astra_militarum_desc, R.string.astra_militarum_quote, R.string.astra_militarum_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.blacktemplars_banner, R.drawable.blacktemplars_logo, R.drawable.blacktemplars_symbol,
        R.string.black_templars_name, R.string.black_templars_desc, R.string.black_templars_quote, R.string.black_templars_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.bloodangels_banner, R.drawable.bloodangels_logo, R.drawable.bloodangels_symbol,
        R.string.blood_angels_name, R.string.blood_angels_desc, R.string.blood_angels_quote, R.string.blood_angels_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.chaosdaemons_banner, R.drawable.chaosdaemons_logo, R.drawable.chaosdaemons_symbol,
        R.string.chaos_daemons_name, R.string.chaos_daemons_desc, R.string.chaos_daemons_quote, R.string.chaos_daemons_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.chaosknights_banner, R.drawable.chaosknights_logo, R.drawable.chaosknights_symbol,
        R.string.chaos_knights_name, R.string.chaos_knights_desc, R.string.chaos_knights_quote, R.string.chaos_knights_quote_source
    ) ,
    FactionOverviewInfo(
        R.drawable.chaosspacemarines_banner, R.drawable.chaosspacemarines_logo, R.drawable.chaosspacemarines_symbol,
        R.string.chaos_space_marines_name, R.string.chaos_space_marines_desc, R.string.chaos_space_marines_quote, R.string.chaos_space_marines_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.darkangels_banner, R.drawable.darkangels_logo, R.drawable.darkangels_symbol,
        R.string.dark_angels_name, R.string.dark_angels_desc, R.string.dark_angels_quote, R.string.dark_angels_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.deathguard_banner, R.drawable.deathguard_logo, R.drawable.deathguard_symbol,
        R.string.death_guard_name, R.string.death_guard_desc, R.string.death_guard_quote, R.string.death_guard_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.deathwatch_banner, R.drawable.deathwatch_logo, R.drawable.deathwatch_symbol,
        R.string.deathwatch_name, R.string.deathwatch_desc, R.string.deathwatch_quote, R.string.deathwatch_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.drukhari_banner, R.drawable.drukhari_logo, R.drawable.drukhari_symbol,
        R.string.drukhari_name, R.string.drukhari_desc, R.string.drukhari_quote, R.string.drukhari_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.genestealercults_banner, R.drawable.genestealercults_logo, R.drawable.genestealercults_symbol,
        R.string.genestealer_cults_name, R.string.genestealer_cults_desc, R.string.genestealer_cults_quote, R.string.genestealer_cults_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.greyknights_banner, R.drawable.greyknights_logo, R.drawable.greyknights_symbol,
        R.string.grey_knights_name, R.string.grey_knights_desc, R.string.grey_knights_quote, R.string.grey_knights_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.imperialagents_banner, R.drawable.imperialagents_logo, R.drawable.imperialagents_symbol,
        R.string.imperial_agents_name, R.string.imperial_agents_desc, R.string.imperial_agents_quote, R.string.imperial_agents_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.imperialknights_banner, R.drawable.imperialknights_logo, R.drawable.imperialknights_symbol,
        R.string.imperial_knights_name, R.string.imperial_knights_desc, R.string.imperial_knights_quote, R.string.imperial_knights_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.leaguesofvotann_banner, R.drawable.leaguesofvotann_logo, R.drawable.leaguesofvotann_symbol,
        R.string.leagues_of_votann_name, R.string.leagues_of_votann_desc, R.string.leagues_of_votann_quote, R.string.leagues_of_votann_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.necrons_banner, R.drawable.necrons_logo, R.drawable.necrons_symbol,
        R.string.necrons_name, R.string.necrons_desc, R.string.necrons_quote, R.string.necrons_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.orks_banner, R.drawable.orks_logo, R.drawable.orks_symbol,
        R.string.orks_name, R.string.orks_desc, R.string.orks_quote, R.string.orks_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.spacemarines_banner, R.drawable.spacemarines_logo, R.drawable.spacemarines_symbol,
        R.string.space_marines_name, R.string.space_marines_desc, R.string.space_marines_quote, R.string.space_marines_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.spacewolves_banner, R.drawable.spacewolves_logo, R.drawable.spacewolves_symbol,
        R.string.space_wolves_name, R.string.space_wolves_desc, R.string.space_wolves_quote, R.string.space_wolves_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.thousandsons_banner, R.drawable.thousandsons_logo, R.drawable.thousandsons_symbol,
        R.string.thousand_sons_name, R.string.thousand_sons_desc, R.string.thousand_sons_quote, R.string.thousand_sons_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.tyranids_banner, R.drawable.tyranids_logo, R.drawable.tyranids_symbol,
        R.string.tyranids_name, R.string.tyranids_desc, R.string.tyranids_quote, R.string.tyranids_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.tau_banner, R.drawable.tau_logo, R.drawable.tau_symbol,
        R.string.tau_name, R.string.tau_desc, R.string.tau_quote, R.string.tau_quote_source
    ),
    FactionOverviewInfo(
        R.drawable.worldeaters_banner, R.drawable.worldeaters_logo, R.drawable.worldeaters_symbol,
        R.string.world_eaters_name, R.string.world_eaters_desc, R.string.world_eaters_quote, R.string.world_eaters_quote_source
    )
)
