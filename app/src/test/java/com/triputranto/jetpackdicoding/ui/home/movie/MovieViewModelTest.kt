package com.triputranto.jetpackdicoding.ui.home.movie

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
class MovieViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieViewModel: MovieViewModel

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel(mock(MyApplication::class.java))
    }

    @Test
    fun getMovies() = runBlocking {
        launch {
            movieViewModel.getAllMovies()
        }
        movieViewModel.getMovies().observeOnce {
            assertNotEquals(0, it.size)
        }
    }
}