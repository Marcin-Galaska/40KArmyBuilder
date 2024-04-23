package com.example.a40karmybuilder.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.a40karmybuilder.a40KArmyBuilderApplication
import com.example.a40karmybuilder.ui.createdarmieslist.CreatedArmiesListViewModel
import com.example.a40karmybuilder.ui.createdarmycomposition.CreatedArmyCompositionViewModel
import com.example.a40karmybuilder.ui.factionoverviewlist.FactionViewModel
import com.example.a40karmybuilder.ui.newarmycreator.NewArmyCreatorViewModel
import com.example.a40karmybuilder.ui.unitselection.UnitSelectionViewModel

object AppViewModelProvider {
    val factory = viewModelFactory {
        initializer {
            val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as a40KArmyBuilderApplication)
            FactionViewModel(
                application.factionDatabase.factionDao()
            )
        }

        initializer {
            CreatedArmiesListViewModel(
                a40karmybuilderApplication().container.armiesRepository
            )
        }

        initializer {
            NewArmyCreatorViewModel(a40karmybuilderApplication().container.armiesRepository)
        }

        initializer {
            CreatedArmyCompositionViewModel(
                this.createSavedStateHandle(),
                a40karmybuilderApplication().container.armiesRepository
            )
        }

        initializer {
            val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as a40KArmyBuilderApplication)
            UnitSelectionViewModel(
                application.unitDatabase.unitDao(),
                a40karmybuilderApplication().container.armiesRepository
            )
        }
    }
}

fun CreationExtras.a40karmybuilderApplication(): a40KArmyBuilderApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as a40KArmyBuilderApplication)