package com.example.toolsmarket.models

import com.google.gson.annotations.SerializedName

sealed class Tool(
    open val title: String = "",
    open val subtitle: String = ""
) {
    data class DefaultTool(
        override val title: String = "",
        override val subtitle: String = "",
        val img: String = ""
    ) : Tool(title, subtitle)

    data class DefaultToolBackground(
        override val title: String = "",
        override val subtitle: String = "",
        val img: String = "",
        val hasBag: String = "#000000"
    ) : Tool(title, subtitle)

    data class ToolWithoutImage(
        override val title: String = "",
        override val subtitle: String = "",
    ) : Tool(title, subtitle)

    data class RoundTool(
        override val title: String = "",
        override val subtitle: String = "",
        val img: String = "",
        val isCircle: Boolean = false
    ) : Tool(title, subtitle)
    data class ErrorTool(
        override val title: String = "error",
        override val subtitle: String = "information about error",
    ): Tool(title, subtitle)
    companion object Factory {
        private fun getTool(res: ToolRequest): Tool {
            return if (res.img == null) {
                ToolWithoutImage(res.title, res.subtitle)
            } else if (res.isCircle != null) {
                RoundTool(res.title, res.subtitle, res.img, res.isCircle)
            } else if (res.hasBag != null) {
                DefaultToolBackground(res.title, res.subtitle, res.img, res.hasBag)
            } else {
                DefaultTool(res.title, res.subtitle, res.img)
            }
        }

        fun getTools(responses: List<ToolRequest>): List<Tool> {
            return responses.map { getTool(it) }
        }
    }
}