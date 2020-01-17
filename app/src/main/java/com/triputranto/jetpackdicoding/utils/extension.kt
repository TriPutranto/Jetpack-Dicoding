package com.triputranto.jetpackdicoding.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}