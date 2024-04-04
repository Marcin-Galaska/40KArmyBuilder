package com.example.a40karmybuilder

import android.app.Application
import com.example.a40karmybuilder.data.AppContainer
import com.example.a40karmybuilder.data.AppDataContainer

class a40KArmyBuilderApplication : Application() {
    // AppContainer instance used by the rest of classes to obtain dependencies
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}