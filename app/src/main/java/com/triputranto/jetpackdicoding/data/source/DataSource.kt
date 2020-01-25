package com.triputranto.jetpackdicoding.data.source

import com.triputranto.jetpackdicoding.base.BaseDataSource
import com.triputranto.jetpackdicoding.data.model.Entity

/**
 * Created by Ahmad Tri Putranto on 26/01/2020.
 * */
interface DataSource : BaseDataSource {
    interface GetAllDataCallback : BaseDataSource.ResponseCallback<List<Entity>>

    interface GetDataByIdCallback : BaseDataSource.ResponseCallback<Entity>

}