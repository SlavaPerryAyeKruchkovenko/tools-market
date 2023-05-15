package com.example.toolsmarket.di.components

import com.example.toolsmarket.MainActivity
import com.example.toolsmarket.ToolsFragment
import com.example.toolsmarket.di.factory.ViewModelFactory
import com.example.toolsmarket.di.modules.NetworkModule
import com.example.toolsmarket.di.modules.ViewModelModule
import dagger.Component

@Component(modules = [NetworkModule::class,ViewModelModule::class])
interface ToolComponent {
    fun viewModelFactory():ViewModelFactory
}