package com.dhimant.mvvm.ui.main.detail

import com.dhimant.mvvm.data.api.Trailer
import com.dhimant.mvvm.databinding.ItemTrailerViewBinding
import com.dhimant.mvvm.ui.base.BaseViewHolder
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
class TrailerAdapter(var mTrailerList: MutableList<Trailer>) : RecyclerView.Adapter<BaseViewHolder>() {

    lateinit var mListener: TrailerAdapterListener


    override fun getItemCount(): Int {
        return if (mTrailerList.size > 0) {
            mTrailerList.size
        } else {
            0
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val mTrailerViewBinding = ItemTrailerViewBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)
        return TrailerViewHolder(mTrailerViewBinding)
    }

    fun addItems(mList: List<Trailer>) {
        mTrailerList.addAll(mList)
        notifyDataSetChanged()
    }

    fun clearItems() {
        mTrailerList.clear()
    }


    interface TrailerAdapterListener {

        fun onItemClick(trailer: Trailer)
    }

    inner class TrailerViewHolder(val mBinding: ItemTrailerViewBinding) : BaseViewHolder(mBinding.root), TrailerItemViewModel.TrailerItemViewModelListener {


        private lateinit var mTrailerItemViewModel: TrailerItemViewModel

        override fun onBind(position: Int) {
            val trailer = mTrailerList[position]
            mTrailerItemViewModel = TrailerItemViewModel(trailer, this)
            mBinding.viewModel = mTrailerItemViewModel

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings()
        }

        override fun onItemClick(trailer: Trailer) {
            mListener.onItemClick(trailer)
        }
    }

}
