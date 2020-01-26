package com.triputranto.jetpackdicoding.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.triputranto.jetpackdicoding.base.BaseViewModel
import com.triputranto.jetpackdicoding.data.model.Entity
import com.triputranto.jetpackdicoding.data.source.DataSource

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class DetailsViewModel : BaseViewModel() {

    private val dataMovie = MutableLiveData<Entity>()
    private val dataTvShow = MutableLiveData<Entity>()

    fun getDataMovie(): LiveData<Entity> = dataMovie
    fun getDataTvShow(): LiveData<Entity> = dataTvShow

    suspend fun getDetailMovie(movieId: Int) {
        eventShowProgress.value = true

        getRepository().getMovieById(movieId, object : DataSource.GetDataByIdCallback {
            override fun onSuccess(data: Entity) {
                eventShowProgress.value = false
                dataMovie.postValue(data)
            }

            override fun onFailed(errorMessage: String?) {
                eventShowProgress.value = false
                eventGlobalMessage.value = errorMessage
            }

        })
    }

    suspend fun getDetailTvShow(tvId: Int) {
        eventShowProgress.value = true

        getRepository().getTvShowById(tvId, object : DataSource.GetDataByIdCallback {
            override fun onSuccess(data: Entity) {
                eventShowProgress.value = false
                dataTvShow.postValue(data)
            }

            override fun onFailed(errorMessage: String?) {
                eventShowProgress.value = false
                eventGlobalMessage.value = errorMessage
            }

        })
    }
}