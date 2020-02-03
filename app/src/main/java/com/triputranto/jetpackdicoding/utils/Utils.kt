package com.triputranto.jetpackdicoding.utils

import com.triputranto.jetpackdicoding.R

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class Utils {
    companion object {
        //key
        const val KEY_MOVIE = "KEY_MOVIE"
        const val KEY_TV_SHOW = "KEY_TV_SHOW"
        const val KEY_FRAGMENT = "KEY_FRAGMENT"

        //category
        const val CATEGORY_MOVIE = 1
        const val CATEGORY_TV = 2

        //load
        const val FIRST_PAGE = 1
        const val PAGE_SIZE = 4
        const val IMAGE_URL = "https://image.tmdb.org/t/p/original"

        //view_pager
        val TAB_TITLES = arrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )

        //room
        const val TABLE_NAME = "movie"
        const val COLUMN_ID = "id"
        const val COLUMN_ID_MOVIE = "id_movie"
        const val COLUMN_TITLE = "title"
        const val COLUMN_NAME = "name"
        const val COLUMN_OVERVIEW = "overview"
        const val COLUMN_RELEASE_DATE = "release_date"
        const val COLUMN_FIRST_RELEASE_DATE = "first_release_date"
        const val COLUMN_POSTER_PATH = "poster_path"
        const val COLUMN_VOTE_AVERAGE = "vote_average"
        const val COLUMN_CATEGORY = "category"
    }
}