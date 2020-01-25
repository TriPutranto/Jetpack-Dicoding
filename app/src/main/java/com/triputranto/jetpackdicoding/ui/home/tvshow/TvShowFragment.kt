package com.triputranto.jetpackdicoding.ui.home.tvshow

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.base.BaseFragment
import com.triputranto.jetpackdicoding.ui.adapter.HomeAdapter
import com.triputranto.jetpackdicoding.ui.details.movie.DetailsMovieActivity
import com.triputranto.jetpackdicoding.utils.Utils
import com.triputranto.jetpackdicoding.utils.gone
import com.triputranto.jetpackdicoding.utils.obtainViewModel
import com.triputranto.jetpackdicoding.utils.visible
import kotlinx.android.synthetic.main.fragment_tv_show.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.anko.startActivity

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class TvShowFragment : BaseFragment(R.layout.fragment_tv_show) {
    private lateinit var mViewModel: TvShowViewModel
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
        CoroutineScope(Dispatchers.Main).launch {
            mViewModel.getAllTvShows()
        }
    }

    private fun setupObserver() {
        mViewModel.apply {
            getTvShows().observe(viewLifecycleOwner, Observer {
                rv_tv_show.visible()
                adapter.setContentList(it)
            })

            eventGlobalMessage.observe(this@TvShowFragment, Observer {
                if (it != null) {
                    rv_tv_show.gone()
                }
            })

            eventShowProgress.observe(this@TvShowFragment, Observer {
                if (it == true) {
                    pg_tv_show.visible()
                } else {
                    pg_tv_show.gone()
                }
            })
        }
    }

    private fun setupRecycler() {
        adapter = HomeAdapter { idMovie ->
            context?.startActivity<DetailsMovieActivity>(Utils.KEY_MOVIE to idMovie)
        }
        rv_tv_show.let {
            it.adapter = adapter
            it.layoutManager = GridLayoutManager(context, 3)
            it.animation = fadeout(context)
        }
    }

    private fun obtainVm(): TvShowViewModel = obtainViewModel(TvShowViewModel::class.java)

}
