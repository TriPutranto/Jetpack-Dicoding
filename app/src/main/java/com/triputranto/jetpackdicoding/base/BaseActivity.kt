@file:Suppress("DEPRECATION")

package com.triputranto.jetpackdicoding.base

import android.annotation.SuppressLint
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.triputranto.jetpackdicoding.R

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
    fun bottomToTop(): Animation =
        AnimationUtils.loadAnimation(this, R.anim.bottom_to_top)

    fun setupToolbar(toolbar: Toolbar?) {
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar?.title = ""
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
        ViewModelProviders.of(this).get(viewModelClass)
}