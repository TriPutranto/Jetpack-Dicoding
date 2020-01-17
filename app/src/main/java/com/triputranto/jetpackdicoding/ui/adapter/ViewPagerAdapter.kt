package com.triputranto.jetpackdicoding.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.ui.home.movie.MovieFragment
import com.triputranto.jetpackdicoding.ui.home.tvshow.TvShowFragment

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)

@Suppress("DEPRECATION")
class ViewPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    private val pages = listOf(
        MovieFragment(),
        TvShowFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return pages.size
    }
}