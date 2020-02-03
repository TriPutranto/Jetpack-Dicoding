package com.triputranto.jetpackdicoding.ui.home.favorite


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.base.BaseFragment
import com.triputranto.jetpackdicoding.utils.Utils.Companion.CATEGORY_MOVIE
import com.triputranto.jetpackdicoding.utils.Utils.Companion.CATEGORY_TV
import kotlinx.android.synthetic.main.fragment_parent_favorite.*

/**
 * Created by Ahmad Tri Putranto on 04/02/2020.
 * */
class ParentFavoriteFragment : BaseFragment(R.layout.fragment_parent_favorite) {

    private lateinit var favoritePagerAdapter: FavoritePagerAdapter

    companion object {
        fun newInstance() = ParentFavoriteFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragment = listOf<Fragment>(
            FavoriteFragment.newInstance(CATEGORY_MOVIE),
            FavoriteFragment.newInstance(CATEGORY_TV)
        )
        favoritePagerAdapter = FavoritePagerAdapter(context, fragment, childFragmentManager)
        view_pager_parent.adapter = favoritePagerAdapter
        tl_parent_favorite.setupWithViewPager(view_pager_parent)
    }
}
