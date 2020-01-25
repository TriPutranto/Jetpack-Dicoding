package com.triputranto.jetpackdicoding.base

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.triputranto.jetpackdicoding.R

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
open class BaseFragment(layout: Int) : Fragment(layout) {
    fun fadeout(context: Context?): Animation =
        AnimationUtils.loadAnimation(context, R.anim.fadeout)
}