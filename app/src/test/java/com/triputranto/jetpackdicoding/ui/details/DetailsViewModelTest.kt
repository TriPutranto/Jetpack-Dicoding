package com.triputranto.jetpackdicoding.ui.details

import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.data.model.Result
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class DetailsViewModelTest {
    private var detailsViewModel: DetailsViewModel? = null
    private var resultMovie: Result? = null
    private var resultTvShow: Result? = null
    private val idDummy = 1
    private var detailsMovie: Result? = null
    private var detailsTvShow: Result? = null

    @Before
    fun setUp() {
        detailsViewModel = DetailsViewModel()
        detailsMovie = detailsViewModel?.getDetailsMovie(idDummy)
        detailsTvShow = detailsViewModel?.getDetailsTvShow(idDummy)
        resultMovie = Result(
            1,
            "Alita : Battle Angel",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            R.drawable.poster_alita,
            "2019",
            67
        )

        resultTvShow = Result(
            1,
            "Arrow",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            R.drawable.poster_arrow,
            "2012",
            76
        )
    }

    @Test
    fun getDetailsMovie() {
        assertEquals(resultMovie?.id, detailsMovie?.id)
        assertEquals(resultMovie?.title, detailsMovie?.title)
        assertEquals(resultMovie?.date, detailsMovie?.date)
        assertEquals(resultMovie?.image, detailsMovie?.image)
        assertEquals(resultMovie?.rating, detailsMovie?.rating)
        assertEquals(resultMovie?.overview, detailsMovie?.overview)
    }

    @Test
    fun getDetailsTvShow() {
        assertEquals(resultTvShow?.id, detailsTvShow?.id)
        assertEquals(resultTvShow?.title, detailsTvShow?.title)
        assertEquals(resultTvShow?.date, detailsTvShow?.date)
        assertEquals(resultTvShow?.image, detailsTvShow?.image)
        assertEquals(resultTvShow?.rating, detailsTvShow?.rating)
        assertEquals(resultTvShow?.overview, detailsTvShow?.overview)
    }
}