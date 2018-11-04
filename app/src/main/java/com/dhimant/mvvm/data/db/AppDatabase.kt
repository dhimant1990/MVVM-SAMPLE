package com.dhimant.mvvm.data.db

import com.dhimant.mvvm.data.api.Movie
import com.dhimant.mvvm.data.db.dao.MovieDao
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import io.reactivex.Observable
import javax.inject.Singleton

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
@Singleton
@Database(entities = [(Movie::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    fun insertMovieToLikes(movie: Movie): Observable<Boolean> {
        return Observable.fromCallable {
            movieDao().insert(movie)
            true
        }
    }

    fun removeMovieFromLikes(movie: Movie): Observable<Boolean> {
        return Observable.fromCallable {
            movieDao().remove(movie)
            true
        }
    }

    /**
     * This method fetch all movies in db matching the movieId .
     * It's implementing the @Query annotation in room persistence library .
     */

    fun loadAllMoviesById(movieId: Int): Observable<List<Movie>> {
        return Observable.fromCallable {
            movieDao().loadAllMoviesById(movieId)
        }
    }

    /**
     * This method fetch all movies in db matching the movieId .
     * It's implementing the @Filter method in RxJava2 .
     * Note : this method does the same as #(loadAllMoviesById) but using another technique
     */

   /* fun loadAllMoviesById(movieId: Int): Observable<List<Movie>> {
        return Observable.fromCallable {
            movieDao().loadAllMovies().filter { it.id == movieId }
        }
    }*/

}