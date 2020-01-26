package com.triputranto.jetpackdicoding.data.source.remote

import com.triputranto.jetpackdicoding.base.BaseApiModel
import com.triputranto.jetpackdicoding.data.model.Entity
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Ahmad Tri Putranto on 26/01/2020.
 * */
interface ApiInterface {
    @GET("discover/movie")
    fun getDiscoverMovieAsync(
        @Query("page") page: Int
    ): Deferred<BaseApiModel<List<Entity>>>

    @GET("discover/tv")
    fun getDiscoverTvShowAsync(
        @Query("page") page: Int
    ): Deferred<BaseApiModel<List<Entity>>>

    @GET("movie/{movie_id}")
    fun getMovieByIdAsync(
        @Path("movie_id") movieId: Int
    ): Deferred<Entity>

    @GET("tv/{tv_id}")
    fun getTvShowByIdAsync(
        @Path("tv_id") tvId: Int
    ): Deferred<Entity>
}