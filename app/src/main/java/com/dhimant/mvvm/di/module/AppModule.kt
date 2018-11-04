package com.dhimant.mvvm.di.module

import com.dhimant.mvvm.R
import com.dhimant.mvvm.data.AppRepository
import com.dhimant.mvvm.data.api.AppWebService
import com.dhimant.mvvm.data.db.AppDatabase
import com.dhimant.mvvm.data.prefrence.AppPrefrence
import com.dhimant.mvvm.utils.AppConstants
import com.dhimant.mvvm.utils.RxSchedule
import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Singleton

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideCalligraphyDefaultConfig(): CalligraphyConfig {
        return CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
    }

    @Provides
    @Singleton
    internal fun provideAppWebService(): AppWebService {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.themoviedb.org/3/")
                .build().create(AppWebService::class.java)
    }


    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.DB_NAME).fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    internal fun provideAppPrefrence(mContext: Context): AppPrefrence {
        return AppPrefrence(mContext)
    }

    @Provides
    @Singleton
    internal fun provideAppRepository(mContext: Context, appdatabase: AppDatabase, appPrefrence: AppPrefrence, appWebService: AppWebService): AppRepository {
        return AppRepository(mContext, appdatabase, appPrefrence, appWebService)
    }

    @Provides
    internal fun provideRxSchedule(): RxSchedule {
        return RxSchedule()
    }

}