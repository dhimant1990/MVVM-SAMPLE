package com.dhimant.mvvm.di.module

import com.dhimant.mvvm.ViewModelProviderFactory
import com.dhimant.mvvm.data.AppRepository
import com.dhimant.mvvm.ui.main.detail.DetailFragment
import com.dhimant.mvvm.ui.main.detail.DetailFragmentViewModel
import com.dhimant.mvvm.ui.main.detail.TrailerAdapter
import com.dhimant.mvvm.utils.RxSchedule
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
@Module
class DetailFragmentModule {

    @Provides
    internal fun provideDetailFragmentViewModel(appRepository: AppRepository, rxSchedule: RxSchedule): DetailFragmentViewModel {
        return DetailFragmentViewModel(appRepository, rxSchedule)
    }

    @Provides
    internal fun provideLinearLayoutManager(fragment: DetailFragment): LinearLayoutManager {
        return LinearLayoutManager(fragment.activity)
    }

    @Provides
    internal fun provideTrailerAdapter(): TrailerAdapter {
        return TrailerAdapter(ArrayList())
    }

   @Provides
    internal fun detailFragmentViewModelProvider(mainViewModel: DetailFragmentViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(mainViewModel)
    }

}