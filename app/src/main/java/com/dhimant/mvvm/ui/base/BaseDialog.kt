package com.dhimant.mvvm.ui.base

import android.app.Dialog
import android.content.Context
import android.databinding.ViewDataBinding
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.view.ViewGroup
import android.view.Window
import android.widget.RelativeLayout

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
abstract class BaseDialog<T : ViewDataBinding, V : BaseViewModel> : DialogFragment() {

    var mActivity: BaseActivity<T, V>? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            val activity = context
            mActivity = activity as BaseActivity<T, V>?
            mActivity?.onFragmentAttached()
        }
    }

    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // the content
        val root = RelativeLayout(activity)
        root.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

        // creating the fullscreen dialog
        val dialog = Dialog(context!!)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(root)
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        dialog.setCanceledOnTouchOutside(false)

        return dialog
    }

    override fun show(fragmentManager: FragmentManager, tag: String) {
        val transaction = fragmentManager.beginTransaction()
        val prevFragment = fragmentManager.findFragmentByTag(tag)
        if (prevFragment != null) {
            transaction.remove(prevFragment)
        }
        transaction.addToBackStack(null)
        show(transaction, tag)
    }

    fun dismissDialog(tag: String) {
        dismiss()
        getBaseActivity()?.onFragmentDetached(tag)
    }

    fun getBaseActivity(): BaseActivity<T, V>? = mActivity

    fun showLoading() = mActivity?.showLoading()

    fun hideLoading() = mActivity?.hideLoading()

    fun hideKeyboard() = mActivity?.hideKeyboard()

    fun isNetworkConnected(): Boolean = mActivity != null && mActivity!!.isNetworkConnected()

}