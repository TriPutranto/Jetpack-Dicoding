package com.triputranto.jetpackdicoding.ui.home.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.triputranto.jetpackdicoding.ui.MyApplication
import com.triputranto.jetpackdicoding.ui.utils.observeOnce
import com.triputranto.jetpackdicoding.utils.Utils.Companion.CATEGORY_MOVIE
import com.triputranto.jetpackdicoding.utils.Utils.Companion.CATEGORY_TV
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

/**
 * Created by Ahmad Tri Putranto on 04/02/2020.
 * */
class FavoriteViewModelTest {

    private lateinit var favoriteViewModel: FavoriteViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        favoriteViewModel = FavoriteViewModel(mock(MyApplication::class.java))
    }

    @Test
    fun getAllLocalMovie() {
        favoriteViewModel.getAllLocalMovie(CATEGORY_MOVIE)?.observeOnce {
            assertNotNull(it)
        }
    }

    @Test
    fun getAllLocalTvShow() {
        favoriteViewModel.getAllLocalMovie(CATEGORY_TV)?.observeOnce {
            assertNotNull(it)
        }
    }
}