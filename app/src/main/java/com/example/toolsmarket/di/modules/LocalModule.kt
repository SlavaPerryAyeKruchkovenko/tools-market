package com.example.toolsmarket.di.modules

import android.content.Context
import androidx.room.Room
import com.example.toolsmarket.database.AppDataBase
import com.example.toolsmarket.repository.toolslocal.IToolRepositoryLocal
import com.example.toolsmarket.repository.toolslocal.ToolRepositoryLocal
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class LocalModule {
    companion object {
        @Provides
        fun getDataBase(context: Context): AppDataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "AppDataBaseName"
            ).build()
        }

        @Provides
        fun getToolDao(dataBase: AppDataBase) = dataBase.toolsDao()
    }

    @Binds
    @Singleton
    abstract fun getLocalToolRepository(repository: ToolRepositoryLocal): IToolRepositoryLocal
}