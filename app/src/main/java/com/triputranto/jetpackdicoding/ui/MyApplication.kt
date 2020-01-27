package com.triputranto.jetpackdicoding.ui

import android.app.Application
import android.content.Context

/**
 * Created by Ahmad Tri Putranto on 27/01/2020.
 * */
class MyApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: MyApplication? = null

        fun applicationContext(): Context? = instance?.applicationContext
    }
}