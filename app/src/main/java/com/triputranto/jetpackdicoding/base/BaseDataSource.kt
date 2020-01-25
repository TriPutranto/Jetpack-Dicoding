package com.triputranto.jetpackdicoding.base

/**
 * Created by Ahmad Tri Putranto on 26/01/2020.
 * */
interface BaseDataSource {
    interface ResponseCallback<T> {
        fun onSuccess(data: T)
        fun onFailed(errorMessage: String? = "")
    }
}