package com.triputranto.jetpackdicoding.ui.home.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.triputranto.jetpackdicoding.base.BaseViewModel
import com.triputranto.jetpackdicoding.data.model.Entity
import com.triputranto.jetpackdicoding.data.source.DataSource
import com.triputranto.jetpackdicoding.utils.Utils.Companion.FIRST_PAGE

/**
 * Created by Ahmad Tri Putranto on 26/01/2020.
 * */
class MovieViewModel : BaseViewModel() {
    private val movieList = MutableLiveData<List<Entity>>()

    suspend fun getAllMovie() {
        eventShowProgress.value = true
        getRepository().getMovies(FIRST_PAGE, object : DataSource.GetAllDataCallback {
            override fun onSuccess(data: List<Entity>) {
                if (data.isNotEmpty()) {
                    eventShowProgress.value = false
                    movieList.value = data
                }
            }

            override fun onFailed(errorMessage: String?) {
                eventShowProgress.value = false
                eventGlobalMessage.value = errorMessage
            }
        })
    }

    fun getMovies(): LiveData<List<Entity>> {
        return movieList
    }
}