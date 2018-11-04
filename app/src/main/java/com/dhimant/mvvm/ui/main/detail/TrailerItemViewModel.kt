package com.dhimant.mvvm.ui.main.detail

import com.dhimant.mvvm.data.api.Trailer
import android.databinding.ObservableField

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
class TrailerItemViewModel(var trailer: Trailer, var mListener: TrailerItemViewModelListener) {

    var name: ObservableField<String> = ObservableField(trailer.name)

    fun onPlayVideo() {
        mListener.onItemClick(trailer)
    }


    interface TrailerItemViewModelListener {
        fun onItemClick(trailer: Trailer)
    }
}