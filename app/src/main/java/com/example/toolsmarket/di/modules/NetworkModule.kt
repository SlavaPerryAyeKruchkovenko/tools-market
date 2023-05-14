package com.example.toolsmarket.di.modules

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.toolsmarket.di.factory.ViewModelFactory
import com.example.toolsmarket.repository.ToolsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Provider

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
    fun provideToolsFragmentViewModelFactory(viewModelMap: MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>): ViewModelFactory {
        return ViewModelFactory(viewModelMap)
    }

    @Provides
    fun provideMyViewModel(myViewModelFactory: ViewModelFactory): ViewModelProvider.Factory {
        return myViewModelFactory
    }

}