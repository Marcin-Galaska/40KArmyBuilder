package com.example.a40karmybuilder.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.a40karmybuilder.a40KArmyBuilderApplication
import com.example.a40karmybuilder.ui.factionoverviewlist.FactionOverviewListViewModel
import com.example.a40karmybuilder.ui.home.HomeViewModel

// Provides Factory to create instance of ViewModel for the entire Inventory app
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for HomeViewModel
        initializer {
            HomeViewModel(a40karmybuilderApplication().container.armiesRepository)
        }

//        // Initializer for ItemEditViewModel
//        initializer {
//            ItemEditViewModel(
//                this.createSavedStateHandle()
//            )
//        }
//        // Initializer for ItemEntryViewModel
//        initializer {
//            ItemEntryViewModel(inventoryApplication().container.itemsRepository)
//        }
//
        // Initializer for FactionOverviewListViewModel
        initializer {
            FactionOverviewListViewModel(
                this.createSavedStateHandle(),
                a40karmybuilderApplication().container.armiesRepository
            )
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [InventoryApplication].
 */
fun CreationExtras.a40karmybuilderApplication(): a40KArmyBuilderApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as a40KArmyBuilderApplication)