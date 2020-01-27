package com.triputranto.jetpackdicoding.ui.details.movie

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry.getInstance
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.triputranto.jetpackdicoding.R.id.*
import com.triputranto.jetpackdicoding.utils.EspressoIdlingResource.getEspressoIdlingResource
import com.triputranto.jetpackdicoding.utils.Utils.Companion.KEY_MOVIE
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class DetailsMovieActivityTest {

    private val movieId = 419704

    @Before
    fun setUp() {
        getInstance().register(getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        getInstance().unregister(getEspressoIdlingResource())
    }

    @get:Rule
    val activityRule: ActivityTestRule<DetailsMovieActivity> =
        object : ActivityTestRule<DetailsMovieActivity>(DetailsMovieActivity::class.java) {
            override fun getActivityIntent(): Intent {
                val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
                val result = Intent(targetContext, DetailsMovieActivity::class.java)
                result.putExtra(KEY_MOVIE, movieId)
                return result
            }
        }

    @Test
    fun getData() {
        onView(withId(tv_name)).check(matches(isDisplayed()))
        onView(withId(tv_overview)).check(matches(isDisplayed()))
        onView(withId(tv_date)).check(matches(isDisplayed()))
        onView(withId(img_poster)).check(matches(isDisplayed()))
        onView(withId(rb_rate)).check(matches(isDisplayed()))
        delay()
    }

    private fun delay() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}