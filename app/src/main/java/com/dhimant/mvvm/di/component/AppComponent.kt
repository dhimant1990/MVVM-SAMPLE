package com.dhimant.mvvm.di.component

import com.dhimant.mvvm.PopMovApp
import com.dhimant.mvvm.di.builder.ActivityBuilder
import com.dhimant.mvvm.di.module.AppModule
import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {

    fun inject(app: PopMovApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}