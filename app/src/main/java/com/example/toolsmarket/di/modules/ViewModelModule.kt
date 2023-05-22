package com.example.toolsmarket.di.modules

import androidx.lifecycle.ViewModel
import com.example.toolsmarket.di.ViewModelKey
import com.example.toolsmarket.viewModels.ToolsFragmentViewModel
import dagger.*
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ToolsFragmentViewModel::class)
    abstract fun toolsFragmentViewModel(viewModel: com.example.toolsmarket.viewModels.ToolsFragmentViewModel): ViewModel
}