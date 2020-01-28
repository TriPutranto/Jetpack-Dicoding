package com.triputranto.jetpackdicoding.base

import android.view.animation.Animation
import android.view.animation.AnimationUtils.loadAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.triputranto.jetpackdicoding.R

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
abstract class BaseActivity : AppCompatActivity() {
    fun bottomToTop(): Animation =
        loadAnimation(this, R.anim.bottom_to_top)

    fun setupToolbar(toolbar: Toolbar?) {
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar?.title = ""
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
        ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(viewModelClass)
}