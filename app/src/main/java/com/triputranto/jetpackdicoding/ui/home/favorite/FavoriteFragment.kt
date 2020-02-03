package com.triputranto.jetpackdicoding.ui.home.favorite


import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.triputranto.jetpackdicoding.R
import com.triputranto.jetpackdicoding.base.BaseFragment
import com.triputranto.jetpackdicoding.ui.details.movie.DetailsMovieActivity
import com.triputranto.jetpackdicoding.ui.details.tvshow.DetailsTvShowActivity
import com.triputranto.jetpackdicoding.utils.Utils.Companion.CATEGORY_MOVIE
import com.triputranto.jetpackdicoding.utils.Utils.Companion.CATEGORY_TV
import com.triputranto.jetpackdicoding.utils.Utils.Companion.KEY_MOVIE
import com.triputranto.jetpackdicoding.utils.Utils.Companion.KEY_TV_SHOW
import com.triputranto.jetpackdicoding.utils.hide
import com.triputranto.jetpackdicoding.utils.show
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.jetbrains.anko.startActivity

/**
 * Created by Ahmad Tri Putranto on 04/02/2020.
 * */
class FavoriteFragment : BaseFragment(R.layout.fragment_favorite) {

    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var adapter: FavoriteAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViewModel()
        setupRecycler()
    }

    private fun setupViewModel() {
        favoriteViewModel = obtainVm()
        setupObserver()
        getData()
    }

    private fun setupObserver() {
        favoriteViewModel.apply {
            eventGlobalMessage.observe(viewLifecycleOwner, Observer {
                if (it != null) {
                    rv_favorite.hide()
                    tv_empty.show()
                    tv_empty.text = it
                }
            })
        }
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    private fun getData() {
        when (arguments?.getInt(ARG_SECTION_NUMBER) ?: 1) {
            CATEGORY_MOVIE -> {
                favoriteViewModel.getAllLocalMovie(CATEGORY_MOVIE)
                    ?.observe(viewLifecycleOwner, Observer {
                        adapter.submitList(it)
                        if (it.toList().isNullOrEmpty()) {
                            favoriteViewModel.eventGlobalMessage.postValue("Favorite Movie Still empty")
                        } else {
                            tv_empty.hide()
                            rv_favorite.show()
                        }
                    })

            }
            CATEGORY_TV -> {
                favoriteViewModel.getAllLocalMovie(CATEGORY_TV)
                    ?.observe(viewLifecycleOwner, Observer {
                        adapter.submitList(it)
                        if (it.toList().isNullOrEmpty()) {
                            favoriteViewModel.eventGlobalMessage.postValue("Favorite Tv Still empty")
                        } else {
                            tv_empty.hide()
                            rv_favorite.show()
                        }
                    })
            }
        }
    }

    private fun setupRecycler() {
        when (arguments?.getInt(ARG_SECTION_NUMBER) ?: 1) {
            CATEGORY_MOVIE -> {
                adapter = FavoriteAdapter { idMovie ->
                    context?.startActivity<DetailsMovieActivity>(KEY_MOVIE to idMovie)
                }
            }
            CATEGORY_TV -> {
                adapter = FavoriteAdapter { idTvShow ->
                    context?.startActivity<DetailsTvShowActivity>(KEY_TV_SHOW to idTvShow)
                }
            }
        }
        rv_favorite.let {
            it.adapter = adapter
            it.layoutManager = GridLayoutManager(context, 3)
        }
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): FavoriteFragment {
            return FavoriteFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    private fun obtainVm(): FavoriteViewModel = obtainViewModel(FavoriteViewModel::class.java)
}
