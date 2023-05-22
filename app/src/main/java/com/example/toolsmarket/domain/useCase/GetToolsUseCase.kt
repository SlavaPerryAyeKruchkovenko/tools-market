package com.example.toolsmarket.domain.useCase

import com.example.toolsmarket.domain.helpers.GetToolsState
import com.example.toolsmarket.models.ToolRequest
import com.example.toolsmarket.repository.tools.IToolRepository
import javax.inject.Inject

class GetToolsUseCase @Inject constructor(private val repository: IToolRepository) : IGetToolsUseCase {
    override suspend fun invoke(state: GetToolsState): List<ToolRequest> {
        return repository.getAllTools()
    }
}