package com.example.toolsmarket.repository.tools

import com.example.toolsmarket.models.ToolRequest

interface IToolRepository {
    suspend fun getAllTools(): List<ToolRequest>
}