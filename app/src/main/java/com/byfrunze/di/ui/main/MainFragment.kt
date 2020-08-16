package com.byfrunze.di.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.byfrunze.di.R
import com.byfrunze.di.adapters.MovieListAdapter
import com.byfrunze.di.dagger.ViewModelFactory
import com.byfrunze.di.dagger.helpers.injectViewModel
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment : DaggerFragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    lateinit var adapterMovies: MovieListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var picasso: Picasso

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterMovies = MovieListAdapter(picasso)
        recycler_view_movies.adapter = adapterMovies


        recycler_view_movies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        viewModel.liveDataMovies.observe(viewLifecycleOwner) {
            adapterMovies.setupMovieList(it)

        }



    }
}