package com.dhimant.mvvm

import com.dhimant.mvvm.di.component.DaggerAppComponent
import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Inject

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
class PopMovApp : Application(),HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector : DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var mCalligraphyConfig : CalligraphyConfig

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)
        /*AndroidNetworking.initialize(applicationContext)
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY)
        }*/
        CalligraphyConfig.initDefault(mCalligraphyConfig)
    }

}