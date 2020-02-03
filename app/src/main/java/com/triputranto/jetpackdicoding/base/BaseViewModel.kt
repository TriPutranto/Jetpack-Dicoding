package com.triputranto.jetpackdicoding.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.triputranto.jetpackdicoding.data.source.DataRepository
import com.triputranto.jetpackdicoding.data.source.local.LocalDataSource

/**
 * Created by Ahmad Tri Putranto on 26/01/2020.
 * */
abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository = DataRepository()
    private val mLocalDataSource = LocalDataSource()

    var eventGlobalMessage = MutableLiveData<String>()

    var eventShowProgress = MutableLiveData<Boolean>()

    fun getRepository() = mRepository

    fun getLocalDataSource() = mLocalDataSource

}