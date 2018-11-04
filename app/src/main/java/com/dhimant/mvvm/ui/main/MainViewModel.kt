package com.dhimant.mvvm.ui.main

import com.dhimant.mvvm.data.AppRepository
import com.dhimant.mvvm.ui.base.BaseViewModel
import com.dhimant.mvvm.utils.RxSchedule
import javax.inject.Inject

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
class MainViewModel @Inject constructor(appRepository: AppRepository, rxSchedule: RxSchedule) : BaseViewModel(appRepository, rxSchedule)