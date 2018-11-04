package com.dhimant.mvvm.ui.main.detail

import com.dhimant.mvvm.BR
import com.dhimant.mvvm.R
import com.dhimant.mvvm.data.api.Movie
import com.dhimant.mvvm.data.api.Trailer
import com.dhimant.mvvm.databinding.FragmentDetailBinding
import com.dhimant.mvvm.ui.base.BaseFragment
import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import javax.inject.Inject

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
@SuppressLint("ValidFragment")
class DetailFragment(val movie: Movie) : BaseFragment<FragmentDetailBinding, DetailFragmentViewModel>(), TrailerAdapter.TrailerAdapterListener {

    @Inject
    internal lateinit var mViewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var mLinearLayoutManager: LinearLayoutManager


    @Inject
    lateinit var mTrailerAdapter: TrailerAdapter

    lateinit var mDetailFragmentViewModel: DetailFragmentViewModel
    private lateinit var mFragmentDetailBinding: FragmentDetailBinding
    lateinit var mListener: DetailFragment.DetailFragmentListener

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.fragment_detail

    override fun getViewModel(): DetailFragmentViewModel {
        mDetailFragmentViewModel = ViewModelProviders.of(this, mViewModelFactory).get(DetailFragmentViewModel::class.java)
        return mDetailFragmentViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mTrailerAdapter.mListener = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentDetailBinding = getViewDataBinding()
        setUp()
        subscribeToLiveData()
        mDetailFragmentViewModel.setMovie(movie)
    }


    private fun setUp() {
        mFragmentDetailBinding.trailersRecycler.setHasFixedSize(true)
        mFragmentDetailBinding.trailersRecycler.layoutManager = mLinearLayoutManager
        mFragmentDetailBinding.trailersRecycler.itemAnimator = DefaultItemAnimator()
        mFragmentDetailBinding.trailersRecycler.adapter = mTrailerAdapter

    }

    private fun subscribeToLiveData() {
        mDetailFragmentViewModel.trailerListLiveData.observe(this, Observer { mDetailFragmentViewModel.addTrailerItemsToList(it!!) })
    }


    override fun onItemClick(trailer: Trailer) {
        mListener.onTrailerSelected(trailer)
    }

    interface DetailFragmentListener {
        fun onTrailerSelected(trailer: Trailer)
    }

}