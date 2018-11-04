package com.dhimant.mvvm.di.module

import com.dhimant.mvvm.ui.main.detail.DetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
@Module
abstract class DetailFragmentProvider {

    @ContributesAndroidInjector(modules =[(DetailFragmentModule::class)])
    internal abstract fun provideDetailFragmentFactory(): DetailFragment

}