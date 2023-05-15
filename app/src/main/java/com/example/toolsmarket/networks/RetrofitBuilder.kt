package com.example.toolsmarket.networks

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val url = "https://develtop.ru/study/"
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val toolsApi: ToolsApi = getRetrofit().create(ToolsApi::class.java)
}