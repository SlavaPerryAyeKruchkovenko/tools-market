package com.example.toolsmarket.viewModels

import androidx.lifecycle.*
import com.example.toolsmarket.domain.helpers.GetToolsState
import com.example.toolsmarket.domain.useCase.IGetToolsUseCase
import com.example.toolsmarket.models.Tool
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.toolsmarket.models.ResultOf
import kotlinx.coroutines.launch
import javax.inject.Inject

class ToolsFragmentViewModel @Inject constructor(private val getTools: IGetToolsUseCase) : ViewModel() {
    val liveData = MutableLiveData<ResultOf<List<Tool>?>>()

    fun init() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                getTools(GetToolsState.DEFAULT)
            }
            if (response.isSuccessful) {
                val responses = response.body()
                val tools = responses?.let { Tool.getTools(it) }
                val result = ResultOf.Success(tools)
                liveData.postValue(result)
            } else {
                liveData.postValue(
                    ResultOf.Failure(
                        "internet error",
                        "check your internet connection"
                    )
                )
            }
        }
    }
}
