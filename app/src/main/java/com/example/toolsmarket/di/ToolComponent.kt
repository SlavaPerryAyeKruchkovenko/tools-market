package com.example.toolsmarket.di

import android.app.Application
import com.example.toolsmarket.MainActivity
import dagger.Component

@Component(modules = [NetworkModule::class])
interface ToolComponent {
    fun inject(activity: MainActivity)
}