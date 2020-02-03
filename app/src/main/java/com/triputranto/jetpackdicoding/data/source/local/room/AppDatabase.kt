package com.triputranto.jetpackdicoding.data.source.local.room


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.triputranto.jetpackdicoding.data.model.Entity

/**
 * Created by Ahmad Tri Putranto on 02/02/2020.
 * */
@Database(entities = [(Entity::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context?): AppDatabase? {
            if (INSTANCE == null && context != null) {
                INSTANCE
                    ?: synchronized(this) {
                        INSTANCE
                            ?: buildDatabase(
                                context
                            ).also {
                                INSTANCE = it
                            }
                    }
            }
            return INSTANCE
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "MovieCatalogue.db"
            ).allowMainThreadQueries()
                .build()
    }
}