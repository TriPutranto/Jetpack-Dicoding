package com.triputranto.jetpackdicoding.data.source.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.triputranto.jetpackdicoding.BuildConfig.BASE_URL
import com.triputranto.jetpackdicoding.utils.NetworkUtils.okHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Ahmad Tri Putranto on 26/01/2020.
 * */
object ApiService {

    fun getClient(): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}