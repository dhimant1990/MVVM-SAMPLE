package com.dhimant.mvvm.di.module

import com.dhimant.mvvm.data.AppRepository
import com.dhimant.mvvm.ui.main.MainViewModel
import com.dhimant.mvvm.utils.RxSchedule
import dagger.Module
import dagger.Provides

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
@Module
class MainActivityModule {

    @Provides
    internal fun provideMainViewModel(appRepository: AppRepository, rxSchedule: RxSchedule): MainViewModel {
        return MainViewModel(appRepository, rxSchedule)
    }

   /* @Provides
    internal fun mainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(mainViewModel)
    }*/

}