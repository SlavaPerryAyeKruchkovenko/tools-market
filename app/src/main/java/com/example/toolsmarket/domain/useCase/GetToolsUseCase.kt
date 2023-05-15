package com.example.toolsmarket.domain.useCase

import com.example.toolsmarket.domain.helpers.GetToolsState
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.models.ToolRequest
import com.example.toolsmarket.repository.IToolsRepository
import retrofit2.Response
import javax.inject.Inject

class GetToolsUseCase @Inject constructor(private val repository: IToolsRepository) : IGetToolsUseCase {
    override suspend fun invoke(state: GetToolsState): Response<List<ToolRequest>> {
        return when(state){
            GetToolsState.DEFAULT -> repository.getTools()
            GetToolsState.LEGACY -> repository.getLegacyTools()
            GetToolsState.BROKE -> repository.getBrokeTools()
            else -> repository.getTools()
        }
    }
}