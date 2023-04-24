package com.example.toolsmarket

import android.app.Application
import com.example.toolsmarket.di.DaggerToolComponent
import com.example.toolsmarket.di.NetworkModule
import com.example.toolsmarket.di.ToolComponent

class ToolsApp : Application() {
    lateinit var component: ToolComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerToolComponent.builder().networkModule(NetworkModule(this)).build()

    }
}