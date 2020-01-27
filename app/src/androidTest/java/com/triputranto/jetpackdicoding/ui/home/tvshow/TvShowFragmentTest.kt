package com.triputranto.jetpackdicoding.ui.home.tvshow

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry.getInstance
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.triputranto.jetpackdicoding.R.id.rv_tv_show
import com.triputranto.jetpackdicoding.testing.SingleFragmentActivity
import com.triputranto.jetpackdicoding.utils.EspressoIdlingResource.getEspressoIdlingResource
import com.triputranto.jetpackdicoding.utils.RecyclerViewItemCountAssertion
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class TvShowFragmentTest {

    private val tvShowFragment = TvShowFragment()

    @Rule
    @JvmField
    val activityRule: ActivityTestRule<SingleFragmentActivity> =
        ActivityTestRule(SingleFragmentActivity::class.java)

    @Before
    fun setUp() {
        getInstance().register(getEspressoIdlingResource())
        activityRule.activity.setFragment(tvShowFragment)
    }

    @After
    fun tearDown() {
        getInstance().unregister(getEspressoIdlingResource())
    }

    @Test
    fun getData() {
        onView(withId(rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(rv_tv_show)).check(RecyclerViewItemCountAssertion(20))
    }
}