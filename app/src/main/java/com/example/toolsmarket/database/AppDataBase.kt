package com.example.toolsmarket.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.toolsmarket.database.dao.ToolDao
import com.example.toolsmarket.database.data.ToolEntity

@Database(entities = [ToolEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun toolsDao(): ToolDao
}