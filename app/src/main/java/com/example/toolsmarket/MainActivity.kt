package com.example.toolsmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.toolsmarket.repository.ToolsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var api: ToolsApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (this.application as ToolsApp).component.inject(this)
        lifecycleScope.launch {
            val result = withContext(Dispatchers.IO){
                api.getTools()
            }
            Log.d("Test",result.isSuccessful.toString())
        }
    }
}