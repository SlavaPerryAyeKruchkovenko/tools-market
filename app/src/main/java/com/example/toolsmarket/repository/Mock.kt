package com.example.toolsmarket.repository

import com.example.toolsmarket.models.Tool

class Mock {
    fun getData(): List<Tool> {
        return getTools()
    }

    private fun getTools(): List<Tool> {
        return listOf(
            Tool.ToolWithoutImage("header", "gay"),
            Tool.DefaultTool(
                "header",
                "gay",
                "https://img5.goodfon.ru/original/2048x2048/b/3b/devushka-kosichki-tv-series-netflix-teleserial-2022-wednesda.jpg"
            ),
            Tool.RoundTool(
                "Hello i am putin and i wanna fuck you",
                "Hello",
                "https://s.mediasalt.ru/images/309/309640/original.jpg",
                true
            )
        )
    }
}