@file:Suppress("DEPRECATION")

package com.triputranto.jetpackdicoding.base


import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils.loadAnimation
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.triputranto.jetpackdicoding.R

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
abstract class BaseFragment(layout: Int) : Fragment(layout) {
    fun fadeout(context: Context?): Animation =
        loadAnimation(context, R.anim.fadeout)

    fun <T : ViewModel> Fragment.obtainViewModel(viewModelClass: Class<T>) =
        ViewModelProviders.of(this).get(viewModelClass)
}