package com.triputranto.jetpackdicoding.ui.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.triputranto.jetpackdicoding.ui.MyApplication
import com.triputranto.jetpackdicoding.ui.utils.observeOnce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class DetailsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var detailsViewModel: DetailsViewModel
    private val movieId = 419704
    private val tvId = 1412

    @Before
    fun setUp() {
        detailsViewModel = DetailsViewModel(mock(MyApplication::class.java))
    }

    @Test
    fun detailMovie() = runBlocking {
        launch {
            detailsViewModel.getDetailMovie(movieId)
        }
        detailsViewModel.getDataMovie().observeOnce {
            assertNotNull(it)
        }
    }

    @Test
    fun detailTvShow() = runBlocking {
        launch {
            detailsViewModel.getDetailTvShow(tvId)
        }
        detailsViewModel.getDataTvShow().observeOnce {
            assertNotNull(it)
        }
    }
}