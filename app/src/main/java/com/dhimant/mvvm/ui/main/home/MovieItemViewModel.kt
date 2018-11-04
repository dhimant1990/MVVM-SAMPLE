package com.dhimant.mvvm.ui.main.home

import com.dhimant.mvvm.data.api.Movie
import android.databinding.ObservableField

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
class MovieItemViewModel(var movie: Movie, var mListener: MovieItemViewModelListener) {

    var imageUrl: ObservableField<String> = ObservableField(movie.poster_path)

    fun onItemClick() {
        mListener.onItemClick(movie)
    }


    interface MovieItemViewModelListener {
        fun onItemClick(movie: Movie)
    }
}