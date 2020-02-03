package com.triputranto.jetpackdicoding.ui.home.tvshow

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.base.BaseFragment
import com.triputranto.jetpackdicoding.ui.adapter.HomeAdapter
import com.triputranto.jetpackdicoding.ui.details.tvshow.DetailsTvShowActivity
import com.triputranto.jetpackdicoding.utils.Utils.Companion.KEY_TV_SHOW
import com.triputranto.jetpackdicoding.utils.hide
import com.triputranto.jetpackdicoding.utils.show
import kotlinx.android.synthetic.main.fragment_tv_show.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import org.jetbrains.anko.startActivity

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class TvShowFragment : BaseFragment(R.layout.fragment_tv_show) {
    private lateinit var mViewModel: TvShowViewModel
    private lateinit var adapter: HomeAdapter

    companion object {
        fun newInstance() = TvShowFragment()
    }

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
            mViewModel.getAllTvShows()
        }
    }

    private fun setupObserver() {
        mViewModel.apply {
            getTvShows().observe(viewLifecycleOwner, Observer {
                rv_tv_show.show()
                adapter.setContentList(it)
            })
            eventShowProgress.observe(viewLifecycleOwner, Observer {
                if (it == true) {
                    pg_tv_show.show()
                } else {
                    pg_tv_show.hide()
                }
            })
        }
    }

    private fun setupRecycler() {
        adapter = HomeAdapter { idTvShow ->
            context?.startActivity<DetailsTvShowActivity>(KEY_TV_SHOW to idTvShow)
        }
        rv_tv_show.let {
            it.adapter = adapter
            it.layoutManager = GridLayoutManager(context, 3)
            it.animation = fadeout(context)
        }
    }

    private fun obtainVm(): TvShowViewModel = obtainViewModel(TvShowViewModel::class.java)
}
