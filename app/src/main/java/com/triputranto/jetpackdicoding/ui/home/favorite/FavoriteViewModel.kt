package com.triputranto.jetpackdicoding.ui.home.favorite

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.triputranto.jetpackdicoding.base.BaseViewModel
import com.triputranto.jetpackdicoding.data.model.Entity
import com.triputranto.jetpackdicoding.utils.Utils.Companion.PAGE_SIZE

/**
 * Created by Ahmad Tri Putranto on 04/02/2020.
 * */
class FavoriteViewModel(application: Application) : BaseViewModel(application) {
    fun getAllLocalMovie(category: Int): LiveData<PagedList<Entity>>? =
        getLocalDataSource().getAllLocalData(category)?.toLiveData(PAGE_SIZE)
}