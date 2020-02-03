package com.triputranto.jetpackdicoding.ui.details

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.triputranto.jetpackdicoding.base.BaseViewModel
import com.triputranto.jetpackdicoding.data.model.Entity
import com.triputranto.jetpackdicoding.data.source.DataSource
import com.triputranto.jetpackdicoding.utils.EspressoIdlingResource
import com.triputranto.jetpackdicoding.utils.EspressoIdlingResource.decrement
import com.triputranto.jetpackdicoding.utils.EspressoIdlingResource.increment
import com.triputranto.jetpackdicoding.utils.Utils.Companion.CATEGORY_MOVIE
import com.triputranto.jetpackdicoding.utils.Utils.Companion.CATEGORY_TV

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class DetailsViewModel(application: Application) : BaseViewModel(application) {

    private val dataMovie = MutableLiveData<Entity>()
    private val dataTvShow = MutableLiveData<Entity>()
    var checkFavorite = MutableLiveData<Boolean>()

    fun getDataMovie(): LiveData<Entity> = dataMovie
    fun getDataTvShow(): LiveData<Entity> = dataTvShow

    //remote
    suspend fun getDetailMovie(movieId: Int) {
        increment()
        eventShowProgress.value = true
        getRepository().getMovieById(movieId, object : DataSource.GetDataByIdCallback {
            override fun onSuccess(data: Entity) {
                eventShowProgress.value = false
                dataMovie.apply {
                    data.category = CATEGORY_MOVIE
                    postValue(data)
                }

                if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                    decrement()
                }
            }

            override fun onFailed(errorMessage: String?) {
                eventShowProgress.value = false
                eventGlobalMessage.value = errorMessage
            }

        })
    }

    suspend fun getDetailTvShow(tvId: Int) {
        eventShowProgress.value = true
        increment()
        getRepository().getTvShowById(tvId, object : DataSource.GetDataByIdCallback {
            override fun onSuccess(data: Entity) {
                eventShowProgress.value = false
                dataTvShow.apply {
                    data.category = CATEGORY_TV
                    postValue(data)
                }
                if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow) {
                    decrement()
                }
            }

            override fun onFailed(errorMessage: String?) {
                eventShowProgress.value = false
                eventGlobalMessage.value = errorMessage
            }

        })
    }

    //local
    fun checkFavorite(movieId: Int): Boolean {
        var isFavorite = false
        getRepository().getLocalDataById(movieId, object : DataSource.GetDataByIdCallback {
            override fun onSuccess(data: Entity) {
                isFavorite = data.id != null
            }

            override fun onFailed(errorMessage: String?) {
                eventGlobalMessage.value = errorMessage
            }
        })
        return isFavorite
    }

    fun addToFavorite(data: Entity) {
        getRepository().insertToLocalData(data)
        checkFavorite.value = true
    }

    fun removeFavorite(id: Int) {
        getRepository().deleteLocalData(id)
        checkFavorite.value = false
    }
}