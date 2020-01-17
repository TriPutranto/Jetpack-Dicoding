package com.triputranto.jetpackdicoding.ui.details.tvshow

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.base.BaseActivity
import com.triputranto.jetpackdicoding.data.model.Result
import com.triputranto.jetpackdicoding.ui.details.DetailsViewModel
import com.triputranto.jetpackdicoding.utils.Utils.Companion.KEY_TV_SHOW
import kotlinx.android.synthetic.main.activity_details_tv_show.*
import kotlinx.android.synthetic.main.content_main.*

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class DetailsTvShowActivity : BaseActivity() {

    private val idTvShow by lazy {
        intent.getIntExtra(KEY_TV_SHOW, 0)
    }

    private val detailsViewModel by lazy {
        ViewModelProviders.of(this).get(DetailsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_tv_show)
        setupToolbar(toolbar)
        showDetails(detailsViewModel.getDetailsTvShow(idTvShow))
    }

    private fun showDetails(tvShow: Result?) {
        Glide.with(this)
            .load(tvShow?.image)
            .placeholder(R.drawable.ic_broken_image_black_24dp)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(img_poster)

        val rating = tvShow?.rating?.div(20)
        if (rating != null) {
            rb_rate.rating = rating.toFloat()
        }

        tv_name.text = tvShow?.title
        tv_overview.text = tvShow?.overview
        tv_date.text = tvShow?.date
    }
}
