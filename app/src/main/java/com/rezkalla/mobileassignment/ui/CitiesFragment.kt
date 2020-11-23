package com.rezkalla.mobileassignment.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rezkalla.mobileassignment.R
import com.rezkalla.mobileassignment.presentation.CitiesViewModel
import com.rezkalla.mobileassignment.utils.VerticalSpaceItemDecoration
import com.rezkalla.mobileassignment.utils.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_cities.*
import javax.inject.Inject

class CitiesFragment : Fragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory<CitiesViewModel>

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(CitiesViewModel::class.java)
    }

    @Inject
    lateinit var citiesAdapter: CitiesAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.citiesLiveData.observe(requireActivity(), Observer { cities ->
            cities?.let {
                citiesAdapter.updateCities(it)
            }

        })
    }

    private fun setupRecyclerView() {
        rclCities?.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            addItemDecoration(VerticalSpaceItemDecoration(24))
            adapter = citiesAdapter
        }
    }

}