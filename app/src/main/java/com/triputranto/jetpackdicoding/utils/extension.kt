@file:Suppress("DEPRECATION")

package com.triputranto.jetpackdicoding.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.triputranto.jetpackdicoding.R

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
fun ViewGroup.inflate(layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)

fun View.show() {
    visibility = VISIBLE
}

fun View.hide() {
    visibility = GONE
}

fun createCircularProgressDrawable(context: Context): CircularProgressDrawable {
    val circularProgressDrawable = CircularProgressDrawable(context)
    circularProgressDrawable.strokeWidth = 4f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.setColorSchemeColors(
        ContextCompat.getColor(
            context,
            R.color.colorAccent
        )
    )
    circularProgressDrawable.start()
    return circularProgressDrawable
}

