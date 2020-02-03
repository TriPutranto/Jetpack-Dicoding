package com.triputranto.jetpackdicoding.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.triputranto.jetpackdicoding.utils.Utils.Companion.COLUMN_CATEGORY
import com.triputranto.jetpackdicoding.utils.Utils.Companion.COLUMN_FIRST_RELEASE_DATE
import com.triputranto.jetpackdicoding.utils.Utils.Companion.COLUMN_ID
import com.triputranto.jetpackdicoding.utils.Utils.Companion.COLUMN_ID_MOVIE
import com.triputranto.jetpackdicoding.utils.Utils.Companion.COLUMN_NAME
import com.triputranto.jetpackdicoding.utils.Utils.Companion.COLUMN_OVERVIEW
import com.triputranto.jetpackdicoding.utils.Utils.Companion.COLUMN_POSTER_PATH
import com.triputranto.jetpackdicoding.utils.Utils.Companion.COLUMN_RELEASE_DATE
import com.triputranto.jetpackdicoding.utils.Utils.Companion.COLUMN_TITLE
import com.triputranto.jetpackdicoding.utils.Utils.Companion.COLUMN_VOTE_AVERAGE
import com.triputranto.jetpackdicoding.utils.Utils.Companion.TABLE_NAME
import kotlinx.android.parcel.Parcelize

/**
 * Created by Ahmad Tri Putranto on 26/01/2020.
 * */
@Entity(tableName = TABLE_NAME)
@Parcelize
data class Entity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID_MOVIE)
    var idMovie: Int? = 0,

    @ColumnInfo(name = COLUMN_ID)
    @SerializedName("id")
    var id: Int? = 0,

    @ColumnInfo(name = COLUMN_TITLE)
    var title: String? = "",

    @ColumnInfo(name = COLUMN_NAME)
    var name: String? = "",

    @ColumnInfo(name = COLUMN_OVERVIEW)
    var overview: String? = "",

    @ColumnInfo(name = COLUMN_POSTER_PATH)
    var poster_path: String? = "",

    @ColumnInfo(name = COLUMN_RELEASE_DATE)
    var release_date: String? = "",

    @ColumnInfo(name = COLUMN_FIRST_RELEASE_DATE)
    var first_air_date: String? = "",

    @ColumnInfo(name = COLUMN_VOTE_AVERAGE)
    var vote_average: Double? = 0.0,

    @ColumnInfo(name = COLUMN_CATEGORY)
    var category: Int
) : Parcelable