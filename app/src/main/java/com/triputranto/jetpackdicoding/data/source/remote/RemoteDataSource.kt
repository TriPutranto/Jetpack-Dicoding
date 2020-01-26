package com.triputranto.jetpackdicoding.data.source.remote

import com.triputranto.jetpackdicoding.data.source.DataSource

/**
 * Created by Ahmad Tri Putranto on 26/01/2020.
 * */
class RemoteDataSource {

    private val mApiService = ApiService.getClient().create(ApiInterface::class.java)

    suspend fun getMovies(page: Int, callback: DataSource.GetAllDataCallback) {
        try {
            val response = mApiService.getDiscoverMovieAsync(page).await()
            val newData = response.results ?: listOf()
            callback.onSuccess(newData)
        } catch (e: Exception) {
            callback.onFailed(e.message)
        }
    }

    suspend fun getTvShows(page: Int, callback: DataSource.GetAllDataCallback) {
        try {
            val response = mApiService.getDiscoverTvShowAsync(page).await()
            val newData = response.results ?: listOf()
            callback.onSuccess(newData)
        } catch (e: Exception) {
            callback.onFailed(e.message)
        }
    }

    suspend fun getMovieById(movieId: Int, callback: DataSource.GetDataByIdCallback) {
        try {
            mApiService.getMovieByIdAsync(movieId).await().let {
                callback.onSuccess(it)
            }
        } catch (e: Exception) {
            callback.onFailed(e.message)
        }
    }

    suspend fun getTvShowById(tvId: Int, callback: DataSource.GetDataByIdCallback) {
        try {
            mApiService.getTvShowByIdAsync(tvId).await().let {
                callback.onSuccess(it)
            }
        } catch (e: Exception) {
            callback.onFailed(e.message)
        }
    }
}