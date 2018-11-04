package com.dhimant.mvvm.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
@Singleton
interface AppWebService {

    companion object {
        const val POPULAR_MOVIES_QUERY: String = ("discover/movie?sort_by=popularity.desc")
        const val API_KEY: String = "api_key"
    }

    @GET(POPULAR_MOVIES_QUERY)
    fun getMostPopular(@Query(API_KEY) apiKey: String): Single<MovieResponse>

    @GET("movie/{movie_id}/videos")
    fun getMovieTrailer(@Path("movie_id") id: Int, @Query(API_KEY) apiKey: String): Single<TrailerResponse>

}