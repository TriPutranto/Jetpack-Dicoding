package com.triputranto.jetpackdicoding.ui.details

import androidx.lifecycle.ViewModel
import com.triputranto.jetpackdicoding.data.model.Result
import com.triputranto.jetpackdicoding.data.source.movies.DataDummyMovies
import com.triputranto.jetpackdicoding.data.source.tvshows.DataDummyTvShows

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class DetailsViewModel : ViewModel() {
    fun getDetailsMovie(id: Int): Result? = DataDummyMovies.getMovieById(id)
    fun getDetailsTvShow(id: Int): Result? = DataDummyTvShows.getTvShowById(id)
}