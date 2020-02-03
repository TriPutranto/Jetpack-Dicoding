package com.triputranto.jetpackdicoding.data.source

import com.triputranto.jetpackdicoding.data.model.Entity
import com.triputranto.jetpackdicoding.data.source.local.LocalDataSource
import com.triputranto.jetpackdicoding.data.source.remote.RemoteDataSource

/**
 * Created by Ahmad Tri Putranto on 26/01/2020.
 * */
class DataRepository : DataSource {

    private val remoteDataSource = RemoteDataSource()
    private val localDataSource = LocalDataSource()

    //remote
    suspend fun getMovies(page: Int, callback: DataSource.GetAllDataCallback) {
        remoteDataSource.getMovies(page, object : DataSource.GetAllDataCallback {
            override fun onSuccess(data: List<Entity>) {
                callback.onSuccess(data)
            }

            override fun onFailed(errorMessage: String?) {
                callback.onFailed(errorMessage)
            }

        })
    }

    suspend fun getTvShows(page: Int, callback: DataSource.GetAllDataCallback) {
        remoteDataSource.getTvShows(page, object : DataSource.GetAllDataCallback {
            override fun onSuccess(data: List<Entity>) {
                callback.onSuccess(data)
            }

            override fun onFailed(errorMessage: String?) {
                callback.onFailed(errorMessage)
            }

        })
    }

    suspend fun getMovieById(movieId: Int, callback: DataSource.GetDataByIdCallback) {
        remoteDataSource.getMovieById(movieId, object : DataSource.GetDataByIdCallback {
            override fun onSuccess(data: Entity) {
                callback.onSuccess(data)
            }

            override fun onFailed(errorMessage: String?) {
                callback.onFailed(errorMessage)
            }

        })
    }

    suspend fun getTvShowById(tvId: Int, callback: DataSource.GetDataByIdCallback) {
        remoteDataSource.getTvShowById(tvId, object : DataSource.GetDataByIdCallback {
            override fun onSuccess(data: Entity) {
                callback.onSuccess(data)
            }

            override fun onFailed(errorMessage: String?) {
                callback.onFailed(errorMessage)
            }

        })
    }

    // local
    fun insertToLocalData(data: Entity) {
        localDataSource.insertToLocalData(data)
    }

    fun getLocalDataById(id: Int, callback: DataSource.GetDataByIdCallback) {
        localDataSource.getLocalDataById(id, object : DataSource.GetDataByIdCallback {
            override fun onSuccess(data: Entity) {
                callback.onSuccess(data)
            }

            override fun onFailed(errorMessage: String?) {
                callback.onFailed(errorMessage)
            }

        })
    }

    fun deleteLocalData(id: Int) {
        localDataSource.deleteFromLocalData(id)
    }
}


