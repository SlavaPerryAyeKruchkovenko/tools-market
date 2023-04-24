package com.example.toolsmarket.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.toolsmarket.repository.ToolsApi
import com.example.toolsmarket.viewModels.ToolsFragmentViewModel
import com.example.toolsmarket.viewModels.ToolsFragmentViewModelFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Provider
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

    @Provides
    fun provideMyViewModelFactory(myViewModelProvider: Provider<ToolsFragmentViewModel>): ToolsFragmentViewModelFactory {
        return ToolsFragmentViewModelFactory(myViewModelProvider)
    }

    @Provides
    fun provideMyViewModel(myViewModelFactory: ToolsFragmentViewModelFactory): ViewModelProvider.Factory {
        return myViewModelFactory
    }

}