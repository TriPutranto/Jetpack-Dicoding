package com.triputranto.jetpackdicoding.ui.home.favorite

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.triputranto.jetpackdicoding.R.id.tl_parent_favorite
import com.triputranto.jetpackdicoding.R.id.view_pager_parent
import com.triputranto.jetpackdicoding.testing.SingleFragmentActivity
import com.triputranto.jetpackdicoding.utils.EspressoIdlingResource.getEspressoIdlingResource
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by Ahmad Tri Putranto on 04/02/2020.
 * */
class ParentFavoriteFragmentTest {

    @get:Rule
    val activityRule = ActivityTestRule(SingleFragmentActivity::class.java)

    private val parentFavoriteFragment = ParentFavoriteFragment()

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(getEspressoIdlingResource())
        activityRule.activity.setFragment(parentFavoriteFragment)
    }

    @Test
    fun favoriteFragmentTest() {
        onView(withId(tl_parent_favorite)).check(matches(isDisplayed()))
        onView(withId(view_pager_parent)).check(matches(isDisplayed()))
    }
}