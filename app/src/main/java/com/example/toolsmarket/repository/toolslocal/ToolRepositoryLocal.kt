package com.example.toolsmarket.repository.toolslocal

import com.example.toolsmarket.database.dao.ToolDao
import com.example.toolsmarket.database.data.ToolEntity
import com.example.toolsmarket.models.ToolRequest
import javax.inject.Inject

class ToolRepositoryLocal @Inject constructor(private val toolsDao: ToolDao) :
    IToolRepositoryLocal {
    override suspend fun getTools(): List<ToolRequest> {
        return toolsDao.getAll()
            .map {
                val isCircle = if (it.isCircle == null) null else it.isCircle > 0
                ToolRequest(it.title, it.subtitle, it.img, it.hasBag, isCircle)
            }
    }

    override suspend fun addTools(tools: List<ToolRequest>) {
        val toolEntities: List<ToolEntity> = tools.map {
            val isCircle = if (it.isCircle == null) null else if (it.isCircle == true) 1 else 0
            ToolEntity(it.title, it.subtitle, it.img, it.hasBag, isCircle)
        }
        toolsDao.softInsert(toolEntities)
    }
}