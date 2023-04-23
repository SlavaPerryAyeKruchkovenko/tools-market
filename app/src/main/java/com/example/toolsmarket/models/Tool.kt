package com.example.toolsmarket.models

sealed class Tool(
    open val title: String,
    open val subtitle: String
) {
    data class DefaultTool(
        override val title: String,
        override val subtitle: String,
        val img: String
    ) : Tool(title, subtitle)

    data class DefaultToolBackground(
        override val title: String,
        override val subtitle: String,
        val img: String,
        val hasBag: String
    ) : Tool(title, subtitle)

    data class ToolWithoutBackground(
        override val title: String,
        override val subtitle: String,
    ) : Tool(title, subtitle)

    data class RoundTool(
        override val title: String,
        override val subtitle: String,
        val img: String,
        val isCircle: Boolean
    ) : Tool(title, subtitle)
}