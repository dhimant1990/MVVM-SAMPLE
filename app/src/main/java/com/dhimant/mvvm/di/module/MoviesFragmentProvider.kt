package com.dhimant.mvvm.di.module

import com.dhimant.mvvm.ui.main.home.MoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
@Module
abstract class MoviesFragmentProvider {

    @ContributesAndroidInjector(modules =[(MoviesFragmentModule::class)])
    internal abstract fun provideMainFragmentFactory(): MoviesFragment

}