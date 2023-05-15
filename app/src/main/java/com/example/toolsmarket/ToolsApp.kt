package com.example.toolsmarket

import android.app.Application
import com.example.toolsmarket.di.components.DaggerToolComponent
import com.example.toolsmarket.di.modules.NetworkModule
import com.example.toolsmarket.di.components.ToolComponent

class ToolsApp : Application() {
    lateinit var component: ToolComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerToolComponent.builder().appContext(this).build()
    }
}