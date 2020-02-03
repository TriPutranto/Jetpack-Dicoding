package com.triputranto.jetpackdicoding.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.ui.home.favorite.ParentFavoriteFragment
import com.triputranto.jetpackdicoding.ui.home.movie.MovieFragment
import com.triputranto.jetpackdicoding.ui.home.tvshow.TvShowFragment
import com.triputranto.jetpackdicoding.utils.Utils.Companion.KEY_FRAGMENT
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class HomeActivity : AppCompatActivity() {

    private var content: Fragment = MovieFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottom_nav.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        if (savedInstanceState == null) {
            loadFragment(content)
        } else {
            content = supportFragmentManager.getFragment(savedInstanceState, KEY_FRAGMENT)
                ?: MovieFragment()
            loadFragment(content)
        }
    }

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_movies -> {
                    loadFragment(MovieFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_tv -> {
                    loadFragment(TvShowFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_favorite -> {
                    loadFragment(ParentFavoriteFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun loadFragment(fragment: Fragment) {
        content = fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_container, fragment)
        transaction.commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        supportFragmentManager.putFragment(outState, KEY_FRAGMENT, content)
        super.onSaveInstanceState(outState)
    }
}
