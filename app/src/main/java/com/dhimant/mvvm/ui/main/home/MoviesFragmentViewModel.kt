package com.dhimant.mvvm.ui.main.home

import com.dhimant.mvvm.data.AppRepository
import com.dhimant.mvvm.data.api.Movie
import com.dhimant.mvvm.ui.base.BaseViewModel
import com.dhimant.mvvm.utils.RxSchedule
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.util.Log
import javax.inject.Inject

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
class MoviesFragmentViewModel @Inject constructor(appRepository: AppRepository, rxSchedule: RxSchedule) : BaseViewModel(appRepository, rxSchedule) {

    var movieObservableList: ObservableList<Movie> = ObservableArrayList<Movie>()

    var movieListLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

    init {
        fetchMovies()
    }

    fun addMovieItemsToList(movies: List<Movie>) {
        movieObservableList.clear()
        movieObservableList.addAll(movies)
    }

    fun fetchMovies() {
        mIsLoading.set(true)
        mCompositeDisposable.add(mRepository
                .getMoviesApiCall()
                .subscribeOn(mRxSchedule.io())
                .observeOn(mRxSchedule.ui())
                .subscribe({ movieResponse ->
                    if (movieResponse?.results != null) {
                        movieListLiveData.value = movieResponse.results
                    }
                    mIsLoading.set(false)
                }, { throwable ->
                    Log.v("MoviesFragmentViewModel", throwable.toString())
                    mIsLoading.set(false)
                }))
    }


}