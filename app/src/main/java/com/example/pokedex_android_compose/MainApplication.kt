package com.example.pokedex_android_compose

import android.app.Application
import com.example.pokedex_android_compose.dagger.DaggerAppComponent

class MainApplication : Application() {
    companion object {
        val appComponent = DaggerAppComponent.create()
    }
}