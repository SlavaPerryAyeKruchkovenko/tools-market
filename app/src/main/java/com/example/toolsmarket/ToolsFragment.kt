package com.example.toolsmarket

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toolsmarket.adapters.ToolListAdapter
import com.example.toolsmarket.databinding.FragmentToolsBinding
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.networks.MockNetworkSource
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
        toolsAdapter.submitList(MockNetworkSource().getTools())
        binding.tools.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        binding.tools.adapter = toolsAdapter

        /*val observer = Observer<List<Tool>> { newValue ->
            Log.d("test",newValue.toString())
            toolsAdapter.submitList(newValue)
        }
        viewModel.liveData.observe(viewLifecycleOwner, observer)*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}