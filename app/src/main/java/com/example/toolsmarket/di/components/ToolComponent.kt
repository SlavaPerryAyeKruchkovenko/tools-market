package com.example.toolsmarket.di.components

import android.content.Context
import com.example.toolsmarket.MainActivity
import com.example.toolsmarket.ToolsFragment
import com.example.toolsmarket.di.factory.ViewModelFactory
import com.example.toolsmarket.di.modules.AppModule
import com.example.toolsmarket.di.modules.LocalModule
import com.example.toolsmarket.di.modules.NetworkModule
import com.example.toolsmarket.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.Component.Builder
import javax.inject.Singleton

@Component(modules = [AppModule::class, NetworkModule::class, ViewModelModule::class, LocalModule::class])
@Singleton
interface ToolComponent {
    fun viewModelFactory(): ViewModelFactory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appContext(context: Context): Builder
        fun build(): ToolComponent
    }

}