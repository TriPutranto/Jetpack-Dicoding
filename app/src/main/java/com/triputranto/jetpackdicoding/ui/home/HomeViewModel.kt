package com.triputranto.jetpackdicoding.ui.home

import androidx.lifecycle.ViewModel
import com.triputranto.jetpackdicoding.data.model.Result
import com.triputranto.jetpackdicoding.data.source.local.movies.DataDummyMovies
import com.triputranto.jetpackdicoding.data.source.local.tvshows.DataDummyTvShows

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class HomeViewModel : ViewModel() {
    fun getAllMovie(): List<Result> = DataDummyMovies.getAllMovies()
    fun getAllTvShow(): List<Result> = DataDummyTvShows.getAllTvShows()
}