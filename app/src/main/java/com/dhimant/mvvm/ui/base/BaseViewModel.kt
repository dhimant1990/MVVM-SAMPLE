package com.dhimant.mvvm.ui.base

import com.dhimant.mvvm.data.AppRepository
import com.dhimant.mvvm.utils.RxSchedule
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
abstract class BaseViewModel(appRepository: AppRepository, rxSchedule: RxSchedule) : ViewModel() {

    val mRepository = appRepository
    val mRxSchedule = rxSchedule
    val mCompositeDisposable = CompositeDisposable()
    var mIsLoading = ObservableBoolean(false)

    override fun onCleared() {
        mCompositeDisposable.dispose()
        super.onCleared()
    }

    fun getIsLoading(): ObservableBoolean {
        return mIsLoading
    }

    fun setIsLoading(isLoading: Boolean) {
        mIsLoading.set(isLoading)
    }

}