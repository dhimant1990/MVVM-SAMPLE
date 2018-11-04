package com.dhimant.mvvm.ui.main.home

import com.dhimant.mvvm.BR
import com.dhimant.mvvm.R
import com.dhimant.mvvm.data.api.Movie
import com.dhimant.mvvm.databinding.FragmentMoviesBinding
import com.dhimant.mvvm.ui.base.BaseFragment
import com.dhimant.mvvm.utils.GridSpacingItemDecoration
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.View
import javax.inject.Inject

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
class MoviesFragment : BaseFragment<FragmentMoviesBinding, MoviesFragmentViewModel>(), MovieAdapter.MovieAdapterListener {


    @Inject
    internal lateinit var mViewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var mGridLayoutManager: GridLayoutManager

    @Inject
    lateinit var mGridSpacingItemDecoration: GridSpacingItemDecoration

    @Inject
    lateinit var mMovieAdapter: MovieAdapter


    lateinit var mMoviesFragmentViewModel: MoviesFragmentViewModel
    private lateinit var mFragmentMainBinding: FragmentMoviesBinding
    lateinit var mListener: MainFragmentListener


    override fun getBindingVariable(): Int = BR.viewModel
    override fun getLayoutId(): Int = R.layout.fragment_movies
    override fun getViewModel(): MoviesFragmentViewModel {
        mMoviesFragmentViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MoviesFragmentViewModel::class.java)
        return mMoviesFragmentViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMovieAdapter.mListener = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentMainBinding = getViewDataBinding()
        setUp()
        subscribeToLiveData()
    }

    private fun setUp() {
        mGridLayoutManager.reverseLayout = false
        mGridLayoutManager.isItemPrefetchEnabled = false
        mFragmentMainBinding.moviesRecycler.setHasFixedSize(true)
        mFragmentMainBinding.moviesRecycler.layoutManager = mGridLayoutManager
        mFragmentMainBinding.moviesRecycler.addItemDecoration(mGridSpacingItemDecoration)
        mFragmentMainBinding.moviesRecycler.itemAnimator = DefaultItemAnimator()
        mFragmentMainBinding.moviesRecycler.adapter = mMovieAdapter
    }

    private fun subscribeToLiveData() {
        mMoviesFragmentViewModel.movieListLiveData.observe(this, Observer { mMoviesFragmentViewModel.addMovieItemsToList(it!!) })
    }

    override fun onItemClick(movie: Movie) {
        mListener.onMovieSelected(movie)
    }

    interface MainFragmentListener {
        fun onMovieSelected(movie: Movie)
    }


}