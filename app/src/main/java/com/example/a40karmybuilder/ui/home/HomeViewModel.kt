package com.example.a40karmybuilder.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

class HomeViewModel(): ViewModel() {
    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                HomeViewModel()
            }
        }
    }
}