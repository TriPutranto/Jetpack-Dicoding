package com.triputranto.jetpackdicoding.data.source.local.room

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.triputranto.jetpackdicoding.data.model.Entity

/**
 * Created by Ahmad Tri Putranto on 02/02/2020.
 * */
@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToLocalData(data: Entity)

    @Query("SELECT * FROM movie WHERE category IN(:type) ORDER BY id_movie DESC")
    fun getAllLocalData(type: Int): DataSource.Factory<Int, Entity>

    @Query("SELECT * FROM movie WHERE id = :id")
    fun getLocalDataById(id: Int): Entity

    @Query("DELETE FROM movie WHERE id IN(:id)")
    fun deleteFromLocalData(id: Int)
}