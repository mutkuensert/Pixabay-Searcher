package com.mutkuensert.pixabaysearcher.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.mutkuensert.pixabaysearcher.adapter.CustomAdapter
import com.mutkuensert.pixabaysearcher.databinding.FragmentMainScreenBinding
import com.mutkuensert.pixabaysearcher.viewmodel.MainScreenFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainScreenFragment : Fragment() {
    private lateinit var binding: FragmentMainScreenBinding
    @Inject lateinit var viewModel: MainScreenFragmentViewModel
    private val recyclerAdapter = CustomAdapter(mutableListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.recyclerView.adapter = recyclerAdapter

        observeItems()
    }

    private fun observeItems(){
        viewModel.mainModel.observe(viewLifecycleOwner, Observer { mainModel ->
            mainModel.hits?.let {
                recyclerAdapter.submitList(it.toMutableList())
            }
        })
    }
}