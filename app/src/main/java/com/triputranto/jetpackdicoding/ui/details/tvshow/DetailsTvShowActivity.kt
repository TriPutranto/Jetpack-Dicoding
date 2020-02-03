package com.triputranto.jetpackdicoding.ui.details.tvshow

import android.os.Bundle
import android.view.Menu
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.base.BaseActivity
import com.triputranto.jetpackdicoding.data.model.Entity
import com.triputranto.jetpackdicoding.ui.details.DetailsViewModel
import com.triputranto.jetpackdicoding.utils.Utils.Companion.IMAGE_URL
import com.triputranto.jetpackdicoding.utils.Utils.Companion.KEY_TV_SHOW
import com.triputranto.jetpackdicoding.utils.createCircularProgressDrawable
import com.triputranto.jetpackdicoding.utils.hide
import com.triputranto.jetpackdicoding.utils.show
import kotlinx.android.synthetic.main.activity_details_tv_show.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import org.jetbrains.anko.toast

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class DetailsTvShowActivity : BaseActivity() {

    private lateinit var detailsViewModel: DetailsViewModel
    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false
    private lateinit var entity: Entity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_tv_show)
        setupToolbar(toolbar)
        setupViewModel()
        getData()
    }

    private fun setupViewModel() {
        detailsViewModel = obtainVm()
        setupObserver()
        getData()
    }

    private fun setupObserver() {
        detailsViewModel.apply {
            getDataTvShow().observe(this@DetailsTvShowActivity, Observer {
                showDetails(it)
            })
            eventShowProgress.observe(this@DetailsTvShowActivity, Observer {
                if (it == true) {
                    pg_tv_show.show()
                } else
                    pg_tv_show.hide()
            })
            eventGlobalMessage.observe(this@DetailsTvShowActivity, Observer {
                toast(it)
            })
        }
    }

    private fun getData() {
        intent.getIntExtra(KEY_TV_SHOW, 0).let {
            CoroutineScope(Main).launch {
                detailsViewModel.getDetailTvShow(it)
            }
        }
    }

    private fun showDetails(tvShow: Entity?) {
        Glide.with(this)
            .load(IMAGE_URL + tvShow?.poster_path)
            .thumbnail(0.2f)
            .placeholder(createCircularProgressDrawable(this))
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.ic_broken_image_green)
            .into(img_poster)

        val rating = tvShow?.vote_average?.div(2)
        if (rating != null) {
            rb_rate.rating = rating.toFloat()
        }

        tv_name.text = tvShow?.name
        tv_overview.text = tvShow?.overview
        tv_date.text = tvShow?.first_air_date
    }

    private fun obtainVm(): DetailsViewModel = obtainViewModel(DetailsViewModel::class.java)
}
