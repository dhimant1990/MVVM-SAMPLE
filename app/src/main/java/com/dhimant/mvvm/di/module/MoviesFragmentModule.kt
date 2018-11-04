package com.dhimant.mvvm.di.module

import com.dhimant.mvvm.ViewModelProviderFactory
import com.dhimant.mvvm.data.AppRepository
import com.dhimant.mvvm.ui.main.home.MoviesFragment
import com.dhimant.mvvm.ui.main.home.MoviesFragmentViewModel
import com.dhimant.mvvm.ui.main.home.MovieAdapter
import com.dhimant.mvvm.ui.main.home.MovieAdapter.MovieAdapterListener
import com.dhimant.mvvm.utils.GridSpacingItemDecoration
import com.dhimant.mvvm.utils.RxSchedule
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.widget.GridLayoutManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
@Module
class MoviesFragmentModule {

    @Provides
    internal fun provideMainFragmentViewModel(appRepository: AppRepository, rxSchedule: RxSchedule): MoviesFragmentViewModel {
        return MoviesFragmentViewModel(appRepository, rxSchedule)
    }

    @Provides
    internal fun provideGridLayoutManager(fragment: MoviesFragment): GridLayoutManager {
        return GridLayoutManager(fragment.activity!!,2)
    }

    @Provides
    internal fun provideGridSpacingItemDecoration(): GridSpacingItemDecoration {
        return GridSpacingItemDecoration(2,5,true)
    }

    @Provides
    internal fun provideMovieAdapter(): MovieAdapter {
        return MovieAdapter(ArrayList())
    }

    @Provides
    @Singleton
    internal fun provideMovieAdapterListener(listener: MovieAdapterListener): MovieAdapterListener {
        return listener
    }

    @Provides
    internal fun mainFragmentViewModelProvider(moviesFragmentViewModel: MoviesFragmentViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(moviesFragmentViewModel)
    }

}