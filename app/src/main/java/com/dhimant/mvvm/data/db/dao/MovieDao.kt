package com.dhimant.mvvm.data.db.dao

import com.dhimant.mvvm.data.api.Movie
import android.arch.persistence.room.*

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<Movie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: Movie)

    @Delete
    fun remove(movie: Movie)

    @Query("SELECT * FROM movies WHERE id = :movieId")
    fun loadAllMoviesById(movieId: Int?): List<Movie>

    @Query("SELECT * FROM movies")
    fun loadAllMovies(): List<Movie>

}