package com.dhimant.mvvm.utils

import com.dhimant.mvvm.data.api.Movie
import com.dhimant.mvvm.data.api.Trailer
import com.dhimant.mvvm.ui.main.detail.TrailerAdapter
import com.dhimant.mvvm.ui.main.home.MovieAdapter
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
@BindingAdapter("adapter")
fun addMovieItems(recyclerView: RecyclerView, movies: List<Movie>) {
    val adapter = recyclerView.adapter as? MovieAdapter
    adapter?.clearItems()
    adapter?.addItems(movies)
}

@BindingAdapter("adapter")
fun addTrailerItems(recyclerView: RecyclerView, trailers: List<Trailer>) {
    val adapter = recyclerView.adapter as? TrailerAdapter
    adapter?.clearItems()
    adapter?.addItems(trailers)
}

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    val context = imageView.context
    Glide.with(context).load("http://image.tmdb.org/t/p/w185$url").into(imageView)
}

