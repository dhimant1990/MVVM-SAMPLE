package com.dhimant.mvvm.utils

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
class RxSchedule {

    fun computation(): Scheduler = Schedulers.computation()

    fun io(): Scheduler = Schedulers.io()

    fun ui(): Scheduler = AndroidSchedulers.mainThread()

}