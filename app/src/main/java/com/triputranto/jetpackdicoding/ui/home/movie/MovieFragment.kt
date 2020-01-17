package com.triputranto.jetpackdicoding.ui.home.movie

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
import com.triputranto.jetpackdicoding.ui.details.movie.DetailsMovieActivity
import com.triputranto.jetpackdicoding.ui.home.HomeViewModel
import com.triputranto.jetpackdicoding.utils.Utils.Companion.KEY_MOVIE
import kotlinx.android.synthetic.main.fragment_movie.*
import org.jetbrains.anko.startActivity

/**
 * Created by Ahmad Tri Putranto on 18/01/2020.
 * */
class MovieFragment : BaseFragment() {

    private val homeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    private var movies = listOf<Result>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movies = homeViewModel.getAllMovie()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_movie.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = HomeAdapter(movies, context) { idMovie ->
                context?.startActivity<DetailsMovieActivity>(KEY_MOVIE to idMovie)
            }
            animation = fadeout(context)
        }
    }
}
