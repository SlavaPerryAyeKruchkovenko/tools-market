package com.example.toolsmarket.di

import android.app.Application
import android.content.Context
import com.example.toolsmarket.repository.ToolsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule(private val application: Application) {

    @Provides
    fun getApplication(): Application = application

    @Provides
    fun getContext(): Context = application.baseContext

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