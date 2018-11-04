package com.dhimant.mvvm.data

import com.dhimant.mvvm.data.api.AppWebService
import com.dhimant.mvvm.data.api.Movie
import com.dhimant.mvvm.data.api.MovieResponse
import com.dhimant.mvvm.data.api.TrailerResponse
import com.dhimant.mvvm.data.db.AppDatabase
import com.dhimant.mvvm.data.prefrence.AppPrefrence
import com.dhimant.mvvm.utils.AppConstants
import android.content.Context
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
@Singleton
class AppRepository @Inject constructor(private val mContext: Context,
                                        private val mAppDatabase: AppDatabase,
                                        private val mAppPrefrence: AppPrefrence,
                                        private val mAppWebService: AppWebService) {

    fun getMoviesApiCall(): Single<MovieResponse> = mAppWebService.getMostPopular(AppConstants.API_KEY)

    fun getMovieTrailersApiCall(movieId: Int): Single<TrailerResponse> = mAppWebService.getMovieTrailer(movieId, AppConstants.API_KEY)

    fun loadAllMoviesById(movieId: Int): Observable<List<Movie>> = mAppDatabase.loadAllMoviesById(movieId)

    fun isMovieLike(movieId: Int): Observable<Boolean> {
        return Observable.fromCallable { mAppDatabase.movieDao().loadAllMoviesById(movieId).isNotEmpty() }
    }

    fun insertMovieToLikes(movie: Movie): Observable<Boolean> = mAppDatabase.insertMovieToLikes(movie)

    fun removeMovieFromLikes(movie: Movie): Observable<Boolean> = mAppDatabase.removeMovieFromLikes(movie)

}