package com.triputranto.jetpackdicoding.ui.home.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.base.BaseFragment
import com.triputranto.jetpackdicoding.data.model.Result
import com.triputranto.jetpackdicoding.ui.adapter.HomeAdapter
import com.triputranto.jetpackdicoding.ui.details.tvshow.DetailsTvShowActivity
import com.triputranto.jetpackdicoding.ui.home.HomeViewModel
import com.triputranto.jetpackdicoding.utils.Utils.Companion.KEY_TV_SHOW
import kotlinx.android.synthetic.main.fragment_tv_show.*
import org.jetbrains.anko.startActivity

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class TvShowFragment : BaseFragment() {

    private val homeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    private var tvShows = listOf<Result>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvShows = homeViewModel.getAllTvShow()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_tv_show.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = HomeAdapter(tvShows, context) { idTvShow ->
                context?.startActivity<DetailsTvShowActivity>(KEY_TV_SHOW to idTvShow)
            }
            animation = fadeout(context)
        }
    }
}
