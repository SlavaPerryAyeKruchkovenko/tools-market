package com.example.toolsmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toolsmarket.adapters.ToolListAdapter
import com.example.toolsmarket.databinding.FragmentToolsBinding
import com.example.toolsmarket.models.ResultOf
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.repository.Mock
import com.example.toolsmarket.viewModels.ToolsFragmentViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [ToolsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ToolsFragment : Fragment() {

    private var _binding: FragmentToolsBinding? = null
    private val toolsAdapter = ToolListAdapter()
    private val viewModel = ToolsFragmentViewModel()

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentToolsBinding.inflate(inflater, container, false)
        init()
        viewModel.init()
        return binding.root
    }

    private fun init() {
        binding.tools.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        binding.tools.adapter = toolsAdapter

        val observer = Observer<ResultOf<List<Tool>?>> { newValue ->
            when (newValue) {
                is ResultOf.Success -> toolsAdapter.submitList(newValue.value)
                is ResultOf.Failure -> toolsAdapter.submitList(listOf(newValue.message?.let { x ->
                    newValue.moreInfo?.let { y ->
                        Tool.ErrorTool(
                            x, y
                        )
                    }
                }))
                else -> toolsAdapter.submitList(Mock().getData())
            }

        }
        viewModel.liveData.observe(viewLifecycleOwner, observer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}