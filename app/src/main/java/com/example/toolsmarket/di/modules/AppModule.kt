package com.example.toolsmarket.di.modules

import com.example.toolsmarket.repository.tools.IToolRepository
import com.example.toolsmarket.repository.tools.ToolRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun getToolRepository(repository: ToolRepository): IToolRepository
}