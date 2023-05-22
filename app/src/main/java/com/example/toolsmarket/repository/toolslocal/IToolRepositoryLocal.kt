package com.example.toolsmarket.repository.toolslocal

import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.models.ToolRequest
import retrofit2.Response

interface IToolRepositoryLocal {
    suspend fun getTools(): List<ToolRequest>
    suspend fun addTools(tools: List<ToolRequest>)
}