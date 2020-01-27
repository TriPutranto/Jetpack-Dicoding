package com.triputranto.jetpackdicoding.ui.home.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.triputranto.jetpackdicoding.ui.MyApplication
import com.triputranto.jetpackdicoding.ui.utils.observeOnce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

/**
 * Created by Ahmad Tri Putranto on 27/01/2020.
 * */
class TvShowViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var tvShowViewModel: TvShowViewModel

    @Before
    fun setUp() {
        tvShowViewModel = TvShowViewModel(mock(MyApplication::class.java))
    }

    @Test
    fun getTvShows() = runBlocking {
        launch {
            tvShowViewModel.getAllTvShows()
        }
        tvShowViewModel.getTvShows().observeOnce {
            assertNotEquals(0, it.size)
        }
    }
}