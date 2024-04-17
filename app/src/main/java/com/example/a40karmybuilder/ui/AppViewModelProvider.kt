package com.example.a40karmybuilder.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.a40karmybuilder.a40KArmyBuilderApplication

fun CreationExtras.a40karmybuilderApplication(): a40KArmyBuilderApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as a40KArmyBuilderApplication)