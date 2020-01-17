package com.triputranto.jetpackdicoding.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.ui.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        view_pager.adapter = ViewPagerAdapter(this, supportFragmentManager)
        tabs.setupWithViewPager(view_pager)
    }
}
