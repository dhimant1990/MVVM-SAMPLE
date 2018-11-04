package com.dhimant.mvvm.ui.main.home

import com.dhimant.mvvm.data.api.Movie
import com.dhimant.mvvm.databinding.ItemMovieViewBinding
import com.dhimant.mvvm.ui.base.BaseViewHolder
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
class MovieAdapter(var mMoviesList: MutableList<Movie>) : RecyclerView.Adapter<BaseViewHolder>() {

    lateinit var mListener: MovieAdapterListener


    override fun getItemCount(): Int {
        return if (mMoviesList.size > 0) {
            mMoviesList.size
        } else {
            0
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val mMovieViewBinding = ItemMovieViewBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)
        return MovieViewHolder(mMovieViewBinding)
    }

    fun addItems(mList: List<Movie>) {
        mMoviesList.addAll(mList)
        notifyDataSetChanged()
    }

    fun clearItems() {
        mMoviesList.clear()
    }


    interface MovieAdapterListener {

        fun onItemClick(movie: Movie)
    }

    inner class MovieViewHolder(val mBinding: ItemMovieViewBinding) : BaseViewHolder(mBinding.root), MovieItemViewModel.MovieItemViewModelListener {


        private lateinit var mMovieItemViewModel: MovieItemViewModel

        override fun onBind(position: Int) {
            val movie = mMoviesList[position]
            mMovieItemViewModel = MovieItemViewModel(movie, this)
            mBinding.viewModel = mMovieItemViewModel

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings()
        }

        override fun onItemClick(movie: Movie) {
            mListener.onItemClick(movie)
        }
    }

}
