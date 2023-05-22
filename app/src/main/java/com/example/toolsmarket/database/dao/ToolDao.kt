package com.example.toolsmarket.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.toolsmarket.database.data.ToolEntity

@Dao
interface ToolDao {
    @Query("Select * from ToolEntity")
    suspend fun getAll(): List<ToolEntity>

    @Transaction
    suspend fun softInsert(tools: List<ToolEntity>) {
        deleteAll()
        insertTools(tools)
    }

    @Query("Delete from ToolEntity")
    suspend fun deleteAll()

    @Insert
    suspend fun insertTools(tools: List<ToolEntity>)
}