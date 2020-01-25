package com.triputranto.jetpackdicoding.ui.home.movie

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.base.BaseFragment
import com.triputranto.jetpackdicoding.ui.adapter.HomeAdapter
import com.triputranto.jetpackdicoding.ui.details.movie.DetailsMovieActivity
import com.triputranto.jetpackdicoding.utils.Utils.Companion.KEY_MOVIE
import com.triputranto.jetpackdicoding.utils.gone
import com.triputranto.jetpackdicoding.utils.obtainViewModel
import com.triputranto.jetpackdicoding.utils.visible
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import org.jetbrains.anko.startActivity

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class MovieFragment : BaseFragment(R.layout.fragment_movie) {
    private lateinit var mViewModel: MovieViewModel
    private lateinit var adapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupRecycler()
    }

    private fun setupViewModel() {
        mViewModel = obtainVm()
        setupObserver()
        getData()
    }

    private fun getData() {
        CoroutineScope(Main).launch {
            mViewModel.getAllMovie()
        }
    }

    private fun setupObserver() {
        mViewModel.apply {
            getMovies().observe(viewLifecycleOwner, Observer {
                rv_movie.visible()
                adapter.setContentList(it)
            })

            eventGlobalMessage.observe(this@MovieFragment, Observer {
                if (it != null) {
                    rv_movie.gone()
                }
            })

            eventShowProgress.observe(this@MovieFragment, Observer {
                if (it == true) {
                    pg_movie.visible()
                } else {
                    pg_movie.gone()
                }
            })
        }
    }

    private fun setupRecycler() {
        adapter = HomeAdapter { idMovie ->
            context?.startActivity<DetailsMovieActivity>(KEY_MOVIE to idMovie)
        }
        rv_movie.let {
            it.adapter = adapter
            it.layoutManager = GridLayoutManager(context, 3)
            it.animation = fadeout(context)
        }
    }

    private fun obtainVm(): MovieViewModel = obtainViewModel(MovieViewModel::class.java)

}
