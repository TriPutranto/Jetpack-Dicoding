package com.triputranto.jetpackdicoding.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.base.BaseActivity
import com.triputranto.jetpackdicoding.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        img_logo.animation = bottomToTop()
        tv_name.animation = bottomToTop()

        Handler().postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 1800)
    }
}
