package com.triputranto.jetpackdicoding.ui.details.movie

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.base.BaseActivity
import com.triputranto.jetpackdicoding.data.model.Result
import com.triputranto.jetpackdicoding.ui.details.DetailsViewModel
import com.triputranto.jetpackdicoding.utils.Utils
import kotlinx.android.synthetic.main.activity_details_movie.*
import kotlinx.android.synthetic.main.content_main.*

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class DetailsMovieActivity : BaseActivity() {

    private val idMovie by lazy {
        intent.getIntExtra(Utils.KEY_MOVIE, 0)
    }

    private val detailsViewModel by lazy {
        ViewModelProviders.of(this).get(DetailsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)
        setupToolbar(toolbar)
        showDetails(detailsViewModel.getDetailsMovie(idMovie))
    }

    private fun showDetails(movie: Result?) {
        Glide.with(this)
            .load(movie?.image)
            .placeholder(R.drawable.ic_broken_image_black_24dp)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(img_poster)

        val rating = movie?.rating?.div(20)
        if (rating != null) {
            rb_rate.rating = rating.toFloat()
        }

        tv_name.text = movie?.title
        tv_overview.text = movie?.overview
        tv_date.text = movie?.date
    }
}
