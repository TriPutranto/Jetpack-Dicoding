package com.triputranto.jetpackdicoding.ui.details.movie

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.base.BaseActivity
import com.triputranto.jetpackdicoding.data.model.Entity
import com.triputranto.jetpackdicoding.ui.details.DetailsViewModel
import com.triputranto.jetpackdicoding.utils.Utils.Companion.IMAGE_URL
import com.triputranto.jetpackdicoding.utils.Utils.Companion.KEY_MOVIE
import com.triputranto.jetpackdicoding.utils.createCircularProgressDrawable
import com.triputranto.jetpackdicoding.utils.hide
import com.triputranto.jetpackdicoding.utils.show
import kotlinx.android.synthetic.main.activity_details_movie.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.anko.toast

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class DetailsMovieActivity : BaseActivity() {

    private lateinit var detailsViewModel: DetailsViewModel
    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false
    private lateinit var entity: Entity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)
        setupToolbar(toolbar)
        setupViewModel()
        getData()
    }

    private fun getData() {
        intent.getIntExtra(KEY_MOVIE, 0).let {
            CoroutineScope(Dispatchers.Main).launch {
                detailsViewModel.getDetailMovie(it)
            }
        }
    }

    private fun setupViewModel() {
        detailsViewModel = obtainVm()
        setupObserver()
    }

    private fun setupObserver() {
        detailsViewModel.apply {
            getDataMovie().observe(this@DetailsMovieActivity, Observer {
                showDetails(it)
                entity = it
                isFavorite = detailsViewModel.checkFavorite(it?.id ?: 0)
                setFavorite()
                menuItem?.getItem(0)?.isVisible = true
            })
            eventShowProgress.observe(this@DetailsMovieActivity, Observer {
                if (it == true) {
                    pg_movie.show()
                } else {
                    pg_movie.hide()
                }
            })
            eventGlobalMessage.observe(this@DetailsMovieActivity, Observer {
                toast(it)
            })

            checkFavorite.observe(this@DetailsMovieActivity, Observer {
                if (it == true) {
                    toast(R.string.save)
                } else {
                    toast(R.string.remove)
                }
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu
        menu?.getItem(0)?.isVisible = false
        setFavorite()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.action_favorite -> {
                if (isFavorite) {
                    detailsViewModel.removeFavorite(entity.id ?: 0)
                } else {
                    detailsViewModel.addToFavorite(entity)
                }
                isFavorite = detailsViewModel.checkFavorite(entity.id ?: 0)
                setFavorite()
            }
        }
        return true
    }

    private fun showDetails(movie: Entity?) {
        Glide.with(this)
            .load(IMAGE_URL + movie?.poster_path)
            .thumbnail(0.2f)
            .placeholder(createCircularProgressDrawable(this))
            .transition(withCrossFade())
            .error(R.drawable.ic_broken_image_green)
            .into(img_poster)

        val rating = movie?.vote_average?.div(2)
        if (rating != null) {
            rb_rate.rating = rating.toFloat()
        }

        tv_name.text = movie?.title
        tv_overview.text = movie?.overview
        tv_date.text = movie?.release_date
    }

    private fun setFavorite() {
        if (isFavorite) {
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorited)
        } else {
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        }
    }

    private fun obtainVm(): DetailsViewModel = obtainViewModel(DetailsViewModel::class.java)
}
