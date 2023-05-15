package com.example.toolsmarket.domain.useCase

import com.example.toolsmarket.domain.helpers.GetToolsState
import com.example.toolsmarket.models.ToolRequest
import retrofit2.Response

interface IGetToolsUseCase {
    suspend fun execute(state: GetToolsState): Response<List<ToolRequest>>
}