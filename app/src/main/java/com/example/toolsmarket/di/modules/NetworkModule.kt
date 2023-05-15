package com.example.toolsmarket.di.modules

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.toolsmarket.di.factory.ViewModelFactory
import com.example.toolsmarket.domain.useCase.GetToolsUseCase
import com.example.toolsmarket.domain.useCase.IGetToolsUseCase
import com.example.toolsmarket.networks.ToolsApi
import com.example.toolsmarket.repository.IToolsRepository
import com.example.toolsmarket.repository.ToolsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Provider
import javax.inject.Singleton

@Module
abstract class NetworkModule {
    companion object{
        @Provides
        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://develtop.ru/study/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        fun getApi(retrofit: Retrofit): ToolsApi =
            retrofit.create(ToolsApi::class.java)
    }

    @Binds
    @Singleton
    abstract fun toolsRepository(repository: ToolsRepository): IToolsRepository
    @Binds
    @Singleton
    abstract fun getToolsUseCase(useCase: GetToolsUseCase): IGetToolsUseCase
}