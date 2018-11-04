package com.dhimant.mvvm.di.builder

import com.dhimant.mvvm.ui.main.MainActivity
import com.dhimant.mvvm.di.module.MainActivityModule
import com.dhimant.mvvm.di.module.DetailFragmentProvider
import com.dhimant.mvvm.di.module.MoviesFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (MoviesFragmentProvider::class), (DetailFragmentProvider::class)])
    internal abstract fun bindMainActivity(): MainActivity

}