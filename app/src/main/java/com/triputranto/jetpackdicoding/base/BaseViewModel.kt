package com.triputranto.jetpackdicoding.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.triputranto.jetpackdicoding.data.source.DataRepository

/**
 * Created by Ahmad Tri Putranto on 26/01/2020.
 * */
abstract class BaseViewModel : ViewModel() {
    private val mRepository = DataRepository()

    fun getRepository() = mRepository

    var eventGlobalMessage = MutableLiveData<String>()
    var eventShowProgress = MutableLiveData<Boolean>()
}