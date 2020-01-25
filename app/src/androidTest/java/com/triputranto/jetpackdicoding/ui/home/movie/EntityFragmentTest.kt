package com.triputranto.jetpackdicoding.ui.home.movie

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.triputranto.jetpackdicoding.R.id.rv_movie
import com.triputranto.jetpackdicoding.testing.SingleFragmentActivity
import com.triputranto.jetpackdicoding.utils.RecyclerViewItemCountAssertion
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class EntityFragmentTest {

    private val moviesFragment = MovieFragment()

    @Rule
    @JvmField
    val activityRule: ActivityTestRule<SingleFragmentActivity> =
        ActivityTestRule(SingleFragmentActivity::class.java)

    @Before
    fun setUp() {
        activityRule.activity.setFragment(moviesFragment)
    }

    @Test
    fun getData() {
        onView(withId(rv_movie)).check(matches(isDisplayed()))
        onView(withId(rv_movie)).check(RecyclerViewItemCountAssertion(15))
    }
}