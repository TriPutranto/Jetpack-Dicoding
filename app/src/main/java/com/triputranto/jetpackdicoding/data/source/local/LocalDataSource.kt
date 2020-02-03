package com.triputranto.jetpackdicoding.data.source.local

import android.util.Log
import com.triputranto.jetpackdicoding.data.model.Entity
import com.triputranto.jetpackdicoding.data.source.DataSource
import com.triputranto.jetpackdicoding.data.source.local.room.AppDatabase
import com.triputranto.jetpackdicoding.data.source.local.room.MovieDao
import com.triputranto.jetpackdicoding.ui.MyApplication
import androidx.paging.DataSource as DataSourcePaging

/**
 * Created by Ahmad Tri Putranto on 02/02/2020.
 * */
class LocalDataSource {
    private var movieDao: MovieDao? = null

    init {
        MyApplication.applicationContext()?.let { it ->
            AppDatabase.getInstance(it).let {
                movieDao = it?.movieDao()
            }
        }
    }

    fun getLocalDataById(id: Int, callback: DataSource.GetDataByIdCallback) {
        try {
            movieDao?.getLocalDataById(id)?.let { callback.onSuccess(it) }
        } catch (exception: Exception) {
            callback.onFailed(exception.message)
        }
    }

    fun insertToLocalData(data: Entity) {
        try {
            movieDao?.insertToLocalData(data)
        } catch (exception: Exception) {
            Log.e(TAG, exception.message.toString())
        }
    }

    fun deleteFromLocalData(id: Int) {
        try {
            movieDao?.deleteFromLocalData(id)
        } catch (exception: Exception) {
            Log.e(TAG, exception.message.toString())
        }
    }

    fun getAllLocalData(type: Int): DataSourcePaging.Factory<Int, Entity>? =
        movieDao?.getAllLocalData(type)

    companion object {
        val TAG = LocalDataSource::class.java.simpleName
    }
}