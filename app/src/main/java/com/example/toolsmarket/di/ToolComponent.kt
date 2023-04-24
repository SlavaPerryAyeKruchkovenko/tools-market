package com.example.toolsmarket.di

import android.app.Application
import com.example.toolsmarket.MainActivity
import com.example.toolsmarket.ToolsFragment
import dagger.Component

@Component(modules = [NetworkModule::class])
interface ToolComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: ToolsFragment)
}