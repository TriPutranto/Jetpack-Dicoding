package com.triputranto.jetpackdicoding.ui.home

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class HomeViewModelTest {

    private var homeViewModel: HomeViewModel? = null

    @Before
    fun setUp() {
        homeViewModel = HomeViewModel()
    }

    @Test
    fun getAllMovie() {
        assertNotNull(homeViewModel?.getAllMovie())
        assertEquals(15, homeViewModel?.getAllMovie()?.size)
    }

    @Test
    fun getAllTvShow() {
        assertNotNull(homeViewModel?.getAllTvShow())
        assertEquals(15, homeViewModel?.getAllTvShow()?.size)
    }
}