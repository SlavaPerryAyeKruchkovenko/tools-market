package com.example.toolsmarket.repository.tools

import com.example.toolsmarket.models.ToolRequest
import com.example.toolsmarket.repository.toolslocal.IToolRepositoryLocal
import com.example.toolsmarket.repository.toolsnetwork.IToolsRepositoryNetwork
import javax.inject.Inject

class ToolRepository @Inject constructor(
    private val toolLocalRep: IToolRepositoryLocal,
    private val toolNetworkRep: IToolsRepositoryNetwork
) : IToolRepository {
    override suspend fun getAllTools(): List<ToolRequest> {
        return try {
            val res = toolNetworkRep.getTools()
            if (res.isSuccessful) {
                val tools = res.body()!!
                toolLocalRep.addTools(tools)
                tools
            } else {
                toolLocalRep.getTools()
            }
        } catch (_: Exception) {
            toolLocalRep.getTools()
        }
    }
}