package com.maksewsha.brookly.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.maksewsha.brookly.R
import com.maksewsha.brookly.presentation.adapters.BestAdapter
import com.maksewsha.brookly.presentation.adapters.CarouselAdapter
import com.maksewsha.brookly.presentation.model.BestPresentation
import com.maksewsha.brookly.presentation.model.CarouselPresentation
import com.maksewsha.brookly.presentation.viewmodels.MainViewModel

class MainFragment: Fragment(R.layout.main_fragment) {
    private val mainViewModel by activityViewModels<MainViewModel>()

    private lateinit var carouselRecycler: RecyclerView
    private lateinit var bestRecycler: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        carouselRecycler = view.findViewById(R.id.carousel_recycler)
        bestRecycler = view.findViewById(R.id.best_recycler)

        carouselRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        bestRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        bestRecycler.isNestedScrollingEnabled = false

        mainViewModel.bestList.observe(viewLifecycleOwner, object: Observer<List<BestPresentation>>{
            override fun onChanged(t: List<BestPresentation>?) {
                bestRecycler.adapter = BestAdapter(t!!)
            }
        })

        mainViewModel.errorMessageBest.observe(viewLifecycleOwner, object: Observer<String>{
            override fun onChanged(t: String?) {
                Snackbar.make(view, t!!, Snackbar.LENGTH_SHORT).show()
            }
        })

        mainViewModel.carouselList.observe(viewLifecycleOwner, object: Observer<List<CarouselPresentation>>{
            override fun onChanged(t: List<CarouselPresentation>?) {
                carouselRecycler.adapter = CarouselAdapter(t!!)
            }
        })

        mainViewModel.errorMessageCarousel.observe(viewLifecycleOwner, object: Observer<String>{
            override fun onChanged(t: String?) {
                Snackbar.make(view, t!!, Snackbar.LENGTH_SHORT).show()
            }
        })

        super.onViewCreated(view, savedInstanceState)
    }
}