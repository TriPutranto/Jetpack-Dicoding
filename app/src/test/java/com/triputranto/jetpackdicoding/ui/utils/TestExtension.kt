package com.triputranto.jetpackdicoding.ui.utils

import androidx.lifecycle.*

/**
 * Created by Ahmad Tri Putranto on 27/01/2020.
 * */
fun <T> LiveData<T>.observeOnce(onChangeHandler: (T) -> Unit?) {
    val observer = OneTimeObserver(handler = onChangeHandler)
    observe(observer, observer)
}

class OneTimeObserver<T>(private val handler: (T) -> Unit?) : Observer<T>, LifecycleOwner {

    private val lifeCycle = LifecycleRegistry(this)

    init {
        lifeCycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    override fun onChanged(t: T) {
        handler(t)
        lifeCycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }

    override fun getLifecycle(): Lifecycle = lifeCycle
}