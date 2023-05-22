package com.example.toolsmarket.di.modules

import com.example.toolsmarket.domain.useCase.GetToolsUseCase
import com.example.toolsmarket.domain.useCase.IGetToolsUseCase
import com.example.toolsmarket.networks.ToolsApi
import com.example.toolsmarket.repository.toolsnetwork.IToolsRepositoryNetwork
import com.example.toolsmarket.repository.toolsnetwork.ToolsRepositoryNetwork
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
    abstract fun toolsRepository(repository: ToolsRepositoryNetwork): IToolsRepositoryNetwork
    @Binds
    @Singleton
    abstract fun getToolsUseCase(useCase: GetToolsUseCase): IGetToolsUseCase
}