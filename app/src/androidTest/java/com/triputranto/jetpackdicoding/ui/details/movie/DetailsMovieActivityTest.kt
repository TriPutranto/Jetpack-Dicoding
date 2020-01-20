package com.triputranto.jetpackdicoding.ui.details.movie

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.triputranto.jetpackdicoding.R.id.*
import com.triputranto.jetpackdicoding.utils.FakeDataDummyMovies
import com.triputranto.jetpackdicoding.utils.Utils.Companion.KEY_MOVIE
import org.junit.Rule
import org.junit.Test

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class DetailsMovieActivityTest {

    private val dummyResult = FakeDataDummyMovies.getMovieById(5)

    @get:Rule
    val activityRule: ActivityTestRule<DetailsMovieActivity> =
        object : ActivityTestRule<DetailsMovieActivity>(DetailsMovieActivity::class.java) {
            override fun getActivityIntent(): Intent {
                val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
                val result = Intent(targetContext, DetailsMovieActivity::class.java)
                result.putExtra(KEY_MOVIE, dummyResult?.id)
                return result
            }
        }

    @Test
    fun getData() {
        onView(withId(tv_name)).check(matches(isDisplayed()))
        onView(withId(tv_name)).check(matches(withText(dummyResult?.title)))
        onView(withId(tv_overview)).check(matches(isDisplayed()))
        onView(withId(tv_overview)).check(matches(withText(dummyResult?.overview)))
        onView(withId(tv_date)).check(matches(isDisplayed()))
        onView(withId(tv_date)).check(matches(withText(dummyResult?.date)))
        onView(withId(img_poster)).check(matches(isDisplayed()))
        onView(withId(rb_rate)).check(matches(isDisplayed()))
    }
}