package com.dhimant.mvvm.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
abstract class BaseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(position: Int)
}