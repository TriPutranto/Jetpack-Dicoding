package com.triputranto.jetpackdicoding.ui.home.favorite

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.triputranto.jetpackdicoding.utils.Utils.Companion.TAB_TITLES

/**
 * Created by Ahmad Tri Putranto on 04/02/2020.
 * */
class FavoritePagerAdapter(
    private val context: Context?,
    private val fragment: List<Fragment>,
    fm: FragmentManager
) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment = fragment[position]

    override fun getCount(): Int = fragment.size

    override fun getPageTitle(position: Int): CharSequence? =
        context?.resources?.getString(TAB_TITLES[position])

}